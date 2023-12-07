package edu.project3;

import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class AdocFileGenerator {
    private static final String ADOC_SEPARATOR = "=======================================";
    private static final String ADOC_FORMAT = "====";

    private AdocFileGenerator() {

    }

    public static void writeToAdocFile(List<Path> filesList, List<Log> logs, LocalDate from, LocalDate to) {
        Path currentDirectory = Paths.get("src/main/java/edu/project3").toAbsolutePath();
        Path filePath = currentDirectory.resolve("adoc_output" + ".adoc");
        try (PrintWriter writer = new PrintWriter(new java.io.FileWriter(filePath.toFile()))) {
            writer.println(ADOC_FORMAT + " Общая информация");
            writer.println(ADOC_SEPARATOR);
            writer.println("|        Метрика        |     Значение |");
            writer.println("|         Файл          | " + java.util.Arrays.toString(filesList.toArray()) + " |");
            writer.println("|    Начальная дата     | " + (from) + " |");
            writer.println("|     Конечная дата     | " + (to) + " |");
            writer.println("|  Количество запросов  | " + logs.size() + " |");
            writer.println("| Средний размер ответа | " + Utils.getAverageBytesResponse(logs) + " |");
            writer.println(ADOC_SEPARATOR);
            writer.println(" ");
            writer.println(ADOC_SEPARATOR);
            writer.println(ADOC_FORMAT + " Запрашиваемые ресурсы");
            writer.println("|     Ресурс      | Количество |");
            writer.println(" ");
            var resourceMap = Utils.getRequestResource(logs);
            for (var elem : resourceMap.keySet()) {
                writer.println("|" + elem + "|" + resourceMap.get(elem) + "|");
            }
            writer.println(ADOC_SEPARATOR);
            writer.println(" ");
            writer.println(ADOC_SEPARATOR);
            writer.println(ADOC_FORMAT + " Коды ответа");
            writer.println("| Код |          Имя          | Количество |");
            writer.println(" ");
            var responseCodeMap = Utils.getStatusCode(logs);
            for (var elem : responseCodeMap.keySet()) {
                writer.println(
                    "|" + elem + "|" + HttpStatuses.getDescriptionByCode(elem) + "|" + responseCodeMap.get(elem) + "|");
            }
            writer.println(ADOC_SEPARATOR);
            writer.println(" ");
            writer.println(ADOC_SEPARATOR);
            writer.println(ADOC_FORMAT + " Самые частые IP адреса");
            writer.println("|      Имя      |   Количество  |");
            writer.println(" ");
            var userAgentsMap = Utils.getIpAddresses(logs);
            for (var elem : userAgentsMap.keySet()) {
                writer.println("|" + elem + "|" + userAgentsMap.get(elem) + "|");
            }
            writer.println(ADOC_SEPARATOR);
            writer.println(" ");
            writer.println(ADOC_SEPARATOR);
            writer.println(ADOC_FORMAT + " Самые частые типы запросов");
            writer.println("|     Адрес     | Количество запросов |");
            writer.println(" ");
            var remoteAddressesMap = Utils.getRequestTypes(logs);
            for (var elem : remoteAddressesMap.keySet()) {
                writer.println("|" + elem + "|" + remoteAddressesMap.get(elem) + "|");
            }
            writer.println(ADOC_SEPARATOR);
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }
}
