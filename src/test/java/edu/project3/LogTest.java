package edu.project3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.project3.Main.getFilesPathsToRead;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
class LogTest {
    private final static Logger LOGGER = LogManager.getLogger();
    @Test
    @DisplayName("Test Log")
    void TestGetLog() {
        List<String> stringPath =
            List.of("C:\\IdeaProjects\\project-template-main\\src\\main\\java\\edu\\project3\\nginxs_logs.txt," +
                "C:\\IdeaProjects\\project-template-main\\src\\main\\java\\edu\\project3\\nginxs_logs2.txt");
        java.util.ArrayList<java.nio.file.Path> filePaths = new java.util.ArrayList<>(getFilesPathsToRead(stringPath));
        List<Log> logsList = new java.util.ArrayList<>();
        for (int i = 0; i < filePaths.size(); i++) {
            try (java.util.stream.Stream<String> stream = java.nio.file.Files.lines(filePaths.get(i))) {
                stream.forEach(e -> {
                    Log log = Log.generateLog(e);
                    assertThat(Log.generateLog(e)).isEqualTo(logsList);
                    logsList.add(log);
                });
            } catch (java.io.IOException e) {
                LOGGER.info(e.getMessage());
            }
        }
    }
}
