package edu.hw3.task8;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Collection;
import java.util.List;

public class BackwardIteratorTest {

    @Test
    @DisplayName("Тест BackwardIteratorNext")
    public void backwardIteratorNextTest() {
        Collection<Integer> list= List.of(1,2,3);
        BackwardIterator<Integer> iterator = new BackwardIterator<>(list);
        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(1);
    }
    @Test
    @DisplayName("Тест BackwardIteratorHasNext")
    public void backwardIteratorHasNextTest() {
        Collection<Integer> list= List.of(1,2,3);
        BackwardIterator<Integer> iterator = new BackwardIterator<>(list);
        Integer response = iterator.next();
        assertThat(iterator.hasNext()).isTrue();
        Integer response2 = iterator.next();
        Integer response3 = iterator.next();
        assertThat(iterator.hasNext()).isFalse();
    }

}
