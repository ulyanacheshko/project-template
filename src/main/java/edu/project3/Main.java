package edu.project3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static String DATE_FORMAT = "yyyy-MM-dd";
    private final static String ADOC = "adoc";
    private final static String MARKDOWN = "markdown";
    private static List<String> commandArguments = new ArrayList<>();
    private static List<Log> logsList = new ArrayList<>();
    private static final String START_DATE = "1900-01-01";
    private static final String END_DATE = "4000-01-01";
    private static final String PATH = "--path";

    private Main() {
    }

    @SuppressWarnings({"MissingSwitchDefault", "InnerAssignment"})
    public static void main(String[] args) {

        commandArguments = List.of(args);
        List<String> stringPath = new ArrayList<>();
        LocalDate from = LocalDate.parse(START_DATE, DateTimeFormatter.ofPattern(DATE_FORMAT));
        LocalDate to = LocalDate.parse(END_DATE, DateTimeFormatter.ofPattern(DATE_FORMAT));

        String format = MARKDOWN;
        for (int i = 0; i < commandArguments.size(); i++) {
            switch (commandArguments.get(i)) {
                case PATH -> stringPath = getAllPaths(stringPath);
                case "--from" ->
                    from = LocalDate.parse(commandArguments.get(i + 1), DateTimeFormatter.ofPattern(DATE_FORMAT));
                case "--to" ->
                    to = LocalDate.parse(commandArguments.get(i + 1), DateTimeFormatter.ofPattern(DATE_FORMAT));
                case "--format" -> format = commandArguments.get(i + 1);
            }
        }
        if (stringPath.isEmpty()) {
            throw new RuntimeException("Variable 'path' was not specified");
        }
        ArrayList<Path> filePaths = new ArrayList<>(getFilesPathsToRead(stringPath));
        LocalDate finalTo = to;
        LocalDate finalFrom = from;
        for (int i = 0; i < filePaths.size(); i++) {
            try (Stream<String> stream = Files.lines(filePaths.get(i))) {
                stream.forEach(e -> {
                    Log log = Log.generateLog(e);
                    logsList.add(log);
                });
            } catch (IOException e) {
                LOGGER.info(e.getMessage());
            }
        }
        if (finalFrom.toString().equals(START_DATE)) {
            List<LocalDate> logsListDate = new ArrayList<>();
            for (int i = 0; i < logsList.size(); i++) {
                logsListDate.add(logsList.get(i).timeLocal());
            }
            from = logsListDate.stream().min(java.time.LocalDate::compareTo).orElse(null);
        }
        if (finalTo.toString().equals(END_DATE)) {
            List<LocalDate> logsListDate = new ArrayList<>();
            for (int i = 0; i < logsList.size(); i++) {
                logsListDate.add(logsList.get(i).timeLocal());
            }
            to = logsListDate.stream().max(java.time.LocalDate::compareTo).orElse(null);
        }
        if (format.equals(ADOC)) {
            AdocFileGenerator.writeToAdocFile(filePaths, logsList, from, to);
        } else if (format.equals(MARKDOWN)) {
            MarkdownFileGenerator.writeToMdFile(filePaths, logsList, from, to);
        } else {
            LOGGER.info("Invalid output format. Try using markdown or adoc");
        }
    }

    public static List<Path> getFilesPathsToRead(List<String> filesPath) {
        ArrayList<Path> result = new ArrayList<>();
        int i = 0;
        int size = filesPath.size();
        while (size != 0) {
            java.io.File directory = new java.io.File(filesPath.get(i));
            if (directory.isDirectory()) {
                for (java.io.File file : java.util.Objects.requireNonNull(directory.listFiles())) {
                    result.add(java.nio.file.Paths.get(file.getAbsolutePath()));
                }
            } else if (directory.isFile()) {
                result.add(Path.of(filesPath.get(i)));
            }
            size--;
            i++;
        }
        return result;
    }

    public static List<String> getAllPaths(List<String> stringPath) {
        int i = 0;
        while (i < commandArguments.size()) {
            var commandArgument = commandArguments.get(i++);
            if (commandArgument.equals(PATH)) {
                if (i < commandArguments.size()) {
                    commandArgument = commandArguments.get(i++);
                }
                while (i < commandArguments.size() && !(commandArgument.startsWith("--"))) {
                    stringPath.add(commandArgument);
                    commandArgument = commandArguments.get(i++);
                }

            }
        }
        return stringPath;
    }

}
