package edu.hw2.task4;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CallingInfoTest {
    @Test
    @DisplayName("Calling info")
    void callingInfoTest() {
        CallingInfo call = new CallingInfo("edu.hw2.task4.CallingInfoTest", "callingInfoTest");
        assertThat(call.methodName()).isEqualTo("callingInfoTest");
        assertThat(call.className()).isEqualTo("edu.hw2.task4.CallingInfoTest");
    }
    @Test
    @DisplayName("Calling newInfo")
    void testCallingInfoTest() {
        CallingInfo call = new CallingInfo("edu.hw2.task4.CallingInfoTest", "newCall");
        assertThat(call).isEqualTo(newCall());
    }
    private static CallingInfo newCall() {
        return CallingInfo.callingInfo();
    }

}
