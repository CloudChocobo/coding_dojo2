package ah;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    // est-ce une année bissextile ou non
    public void checkIfLeap() {
        assertEquals(true, App.isLeap(2000));
        assertEquals(false, App.isLeap(2001));
        assertEquals(true, App.isLeap(1600));
        assertEquals(false, App.isLeap(1800));
        assertEquals(true, App.isLeap(1720));
        assertEquals(false, App.isLeap(1725));
        assertEquals(true, App.isLeap(2008));
        assertEquals(false, App.isLeap(1700));
        assertEquals(false, App.isLeap(2100));
    }


    // transformer 745$ en seven hundred and fourty five dollars
    @Test
    public  void numberToWord() {
        assertEquals("zero",  App.convert(0)); //test unité 0 vers zero
        assertEquals("one",  App.convert(1)); // test unité 1 vers one
        assertEquals("five",  App.convert(5));//test unité 5 vers five
        assertEquals("eighteen",  App.convert(18)); // test 18 vers eighteen
        assertEquals("twenty", App.convert(20)); // test 20 to twenty avec la refactorisation
        assertEquals("thirty", App.convert(30)); // test 30 to thirty
        assertEquals("sixty", App.convert(60)); // test 60 to sixty
        //assertEquals("sixty one", App.convert(61));
    }

}