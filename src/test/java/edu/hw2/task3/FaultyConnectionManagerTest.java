package edu.hw2.task3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class FaultyConnectionManagerTest {
    @Test
    public void faultyConnectionManagerTest() {
        Connection connection = new FaultyConnectionManager().getConnection();
        assertThat(connection).isInstanceOf(FaultyConnection.class);
    }
}
