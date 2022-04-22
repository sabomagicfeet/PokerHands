import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @Test
    public void changeCardsInputStringToCardClassArrayListTest() {
        Poker poker = new Poker();
        ArrayList<Card> expectedCardList = new ArrayList();
        expectedCardList.add(new Card(2, 'H'));
        expectedCardList.add(new Card(3, 'D'));
        expectedCardList.add(new Card(5, 'S'));
        expectedCardList.add(new Card(9, 'C'));
        expectedCardList.add(new Card(4, 'D'));

        ArrayList<Card> actualCardList = poker.changeCardsInputStringToCardClassArrayList("2H 3D 5S 9C 4D");

        for(int i = 0; i < expectedCardList.size(); i++) {
            Assertions.assertEquals(true, expectedCardList.get(i).getValue() == actualCardList.get(i).getValue() );
            Assertions.assertEquals(true, expectedCardList.get(i).getSuit() == actualCardList.get(i).getSuit());
        }

    }

    @Test
    public void findHighCardTest() {
        Poker poker = new Poker();

        Card expectedHighCard = new Card(9, 'C');

        ArrayList<Card> cardList = poker.changeCardsInputStringToCardClassArrayList("2H 3D 5S 9C 4D");

        Card actualHighCard = poker.findHighCard(cardList);

        System.out.println("Found high card : " + actualHighCard.getValue() + actualHighCard.getSuit());

        boolean result = expectedHighCard.getValue() == actualHighCard.getValue();

        Assertions.assertEquals(true, result);
    }

    @Test
    public void findHighCardWithJQKATest() {
        Poker poker = new Poker();

        // The value of Ace = 14
        Card expectedHighCard = new Card(14, 'D');

        ArrayList<Card> cardList = poker.changeCardsInputStringToCardClassArrayList("2H JD QS KC AD");

        Card actualHighCard = poker.findHighCard(cardList);

        System.out.println("Found high card : " + actualHighCard.getValue() + actualHighCard.getSuit());

        boolean result = expectedHighCard.getValue() == actualHighCard.getValue();

        Assertions.assertEquals(true, result);
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
//        String a = "11S";
//        String b = "3D";
//
//        if(a > b) {
//
//        }
//    }
}
