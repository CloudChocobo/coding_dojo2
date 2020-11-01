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
    public void numberToWord() {
        assertEquals("zero", App.convert(0)); // test unité 0 vers zero
        assertEquals("one", App.convert(1)); // test unité 1 vers one
        assertEquals("five", App.convert(5));// test unité 5 vers five
        assertEquals("eighteen", App.convert(18)); // test 18 vers eighteen
        assertEquals("twenty", App.convert(20)); // test 20 to twenty avec la refactorisation
        assertEquals("thirty", App.convert(30)); // test 30 to thirty
        assertEquals("sixty", App.convert(60)); // test 60 to sixty
        assertEquals("eighty", App.convert(80)); // test 80 to eighty
        assertEquals("one hundred", App.convert(100)); // test 100 to hundred
        assertEquals("two hundred", App.convert(200));// test 200 to two hundred
        assertEquals("seven hundred", App.convert(700));// test 700 to seven hundred
        assertEquals("twenty one", App.convert(21)); // test 21 to twenty one
        assertEquals("twenty eight", App.convert(28)); // test 28 to twenty eight
        assertEquals("thirty one", App.convert(31));
        assertEquals("thirty five", App.convert(35));
        assertEquals("fourty one", App.convert(41));
        assertEquals("fourty eight", App.convert(48));
        assertEquals("sixty nine", App.convert(69));
        assertEquals("ninety six", App.convert(96));
        assertEquals("one hundred and ten", App.convert(110));
        assertEquals("one hundred and eighteen", App.convert(118));
        assertEquals("one hundred and thirty", App.convert(130));
        assertEquals("one hundred and ninety", App.convert(190));
        assertEquals("one hundred and ninety five", App.convert(195));
        assertEquals("one hundred and fourty five", App.convert(145));
        assertEquals("two hundred and sixteen", App.convert(216));
        assertEquals("two hundred and eleven", App.convert(211));
        assertEquals("two hundred and fifty", App.convert(250));
        assertEquals("two hundred and seventy", App.convert(270));
        assertEquals("two hundred and eighty three", App.convert(283));
        assertEquals("seven hundred and fourty", App.convert(740));

    }

}