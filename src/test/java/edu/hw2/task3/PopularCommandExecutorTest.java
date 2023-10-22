package edu.hw2.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.assertj.core.api.Assertions.*;

class PopularCommandExecutorTest {
    @Test
    public void DefaultConnectionExecutorTest() {
        PopularCommandExecutor executor = new PopularCommandExecutor(new DefaultConnectionManager(), 5);
        try {
            executor.updatePackages();
        } catch (Exception e) {
            assertThat(ConnectionException.class).isEqualTo(e.getCause().getClass());
        }
    }
    @Test
    public void FaultyConnectionExecutorTest() {
        PopularCommandExecutor executor = new PopularCommandExecutor(new FaultyConnectionManager(), 5);
        try {
            executor.updatePackages();
        } catch (Exception e) {
            assertThat(ConnectionException.class).isEqualTo(e.getCause().getClass());
        }

    }
}
