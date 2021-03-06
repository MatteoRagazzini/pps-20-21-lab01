import lab01.tdd.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    CircularList circularList;
    StrategyFactory factory = new StrategyFactory();

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
        assertEquals(2, circularList.next(factory.makeEvenStrategy()).orElse(0));

        circularList.reset();

        assertEquals(3, circularList.next(factory.makeMultipleOfStrategy(3)).orElse(0));

        circularList.reset();

        assertEquals(1, circularList.next(factory.makeEqualsStrategy(1)).orElse(0));
    }

    @Test
    void testNextWithStrategyWithEmptyList(){
        circularList.add(1);
        circularList.add(3);
        assertEquals(Optional.empty(), circularList.next(factory.makeEvenStrategy()));
        assertEquals(Optional.empty(), circularList.next(factory.makeMultipleOfStrategy(5)));
        assertEquals(Optional.empty(), circularList.next(factory.makeEqualsStrategy(5)));
    }





}
