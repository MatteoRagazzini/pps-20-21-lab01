import lab01.tdd.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    CircularList circularList;

    @BeforeEach
    void beforeEach(){
        this.circularList = new CircularListImpl();
    }

    @Test
    void testInitiallyEmpty(){
        assertTrue(circularList.isEmpty());
    }

    @Test
    void testAdd(){
        circularList.add(1);
        assertFalse(circularList.isEmpty());
    }

    @Test
    void testSize(){
        circularList.add(1);
        circularList.add(2);
        assertEquals(2, circularList.size());
    }

    @Test
    void testNext(){
        circularList.add(1);
        circularList.add(2);
        assertEquals(1, circularList.next().orElse(0));
        assertEquals(2, circularList.next().orElse(0));
        assertEquals(1, circularList.next().orElse(0));
    }

    @Test
    void testNextWithEmptyList(){
        assertEquals(Optional.empty(), circularList.next());
    }


    @Test
    void testPrevious(){
        circularList.add(1);
        circularList.add(2);
        assertEquals(2, circularList.previous().orElse(0));
        assertEquals(1, circularList.previous().orElse(0));
    }

    @Test
    void testPreviousWithEmptyList(){
        assertEquals(Optional.empty(), circularList.previous());
    }

    @Test
    void testNextAndPrevious(){
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        assertEquals(1, (circularList.next().orElse(0)));
        assertEquals(1, (circularList.previous().orElse(0)));
        assertEquals(3, (circularList.previous().orElse(0)));
    }

    @Test
    void testReset(){
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        assertEquals(1, circularList.next().orElse(0));
        assertEquals(2, circularList.next().orElse(0));
        circularList.reset();
        assertEquals(1, circularList.next().orElse(0));
    }

    @Test
    void testNextWithStrategy(){
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        assertEquals(2, circularList.next(new EvenStrategy()).orElse(0));

        circularList.reset();

        assertEquals(3, circularList.next(new MultipleOfStrategy(3)).orElse(0));

        circularList.reset();

        assertEquals(1, circularList.next(new EqualsStrategy(1)).orElse(0));
    }

    @Test
    void testNextWithStrategyWithEmptyList(){
        assertEquals(Optional.empty(), circularList.next(new EvenStrategy()));
        assertEquals(0, circularList.next(new MultipleOfStrategy(5)).orElse(0));
        assertEquals(0, circularList.next(new EqualsStrategy(5)).orElse(0));
    }





}
