package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.provider.CsvSource;
import static edu.hw5.SubstringSearch.findSubstring;


class SubstringSearchTest {
    @DisplayName("Поиск подстроки")
    @ParameterizedTest(name = " {0} -> {1}")
    @CsvSource({
        "achfdbaabgabcaabg,abc,true",
        "fdvbklghtrslkm,bklght,true",
        "kuhftdertfgcklj,lbc,false",
        "jhgfrdesrdngbjkjhfd,mhnfd,false",
    }
    )
    void checkPasswordTest(String str,String subStr, boolean expected) {
        boolean response = findSubstring(str,subStr);
        assertThat(response).isEqualTo(expected);
    }

}
