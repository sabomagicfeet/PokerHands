import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class PokerGameTest {

    @Test
    public void compareSimpleNumbersTest() {
        Poker poker = new Poker();

        String expected = "White wins. - with high card: 3";
        String actual = poker.compareSimpleNumbers(2, 3);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void putFiveCardsIntoHashMapTest() {
        Poker poker = new Poker();

        HashMap<Integer, String> expectedHashMap = new HashMap<>();
        expectedHashMap.put(2, "H");
        expectedHashMap.put(3, "D");
        expectedHashMap.put(5, "S");
        expectedHashMap.put(9, "C");
        expectedHashMap.put(4, "D");

        HashMap actualHashMap = poker.putFiveCardsIntoHashMap("2H 3D 5S 9C 4D");

        Assertions.assertEquals(expectedHashMap,actualHashMap);
    }

    @Test
    public void putFiveCardsWithJQKAIntoHashMapTest() {
        Poker poker = new Poker();

        HashMap<Integer, String> expectedHashMap = new HashMap<>();
        expectedHashMap.put(2, "H");
        expectedHashMap.put(11, "D");
        expectedHashMap.put(12, "S");
        expectedHashMap.put(13, "C");
        expectedHashMap.put(14, "D");

        HashMap actualHashMap = poker.putFiveCardsIntoHashMap("2H JD QS KC AD");

        Assertions.assertEquals(expectedHashMap,actualHashMap);
    }

//    @Test
//    public void findHighCardTest() {
//        Poker poker = new Poker();
//
//        String expected = "9C";
//        String actual = poker.findHighCard("2H 3D 5S 9C 4D");
//
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void compareStringTest() {
//
//    }
}
