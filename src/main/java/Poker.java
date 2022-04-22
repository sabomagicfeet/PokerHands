import java.util.HashMap;

public class Poker {
    private static final Integer JACK = 11;
    private static final Integer QUEEN = 12;
    private static final Integer KING = 13;
    private static final Integer ACE = 14;


    public String compareSimpleNumbers(int black, int white) {
        if(black > white) {
            return "Black wins. - with high card: " + black;
        } else {
            return "White wins. - with high card: " + white;
        }
    }

    public HashMap<Integer, String> putFiveCardsIntoHashMap(String fiveCards) {
        HashMap<Integer, String> cardHashMap = new HashMap();

        // change J,Q,K,A to integer values
        // put each card string to HashMap <Integer, String>
        for( String eachCard : fiveCards.split(" ") ) {
            if(eachCard.charAt(0) == 'J') {
                cardHashMap.put(JACK, String.valueOf(eachCard.charAt(1)) );
            } else if(eachCard.charAt(0) == 'Q') {
                cardHashMap.put(QUEEN, String.valueOf(eachCard.charAt(1)) );
            } else if(eachCard.charAt(0) == 'K') {
                cardHashMap.put(KING, String.valueOf(eachCard.charAt(1)) );
            } else if(eachCard.charAt(0) == 'A') {
                cardHashMap.put(ACE, String.valueOf(eachCard.charAt(1)) );
            } else {
                cardHashMap.put(Integer.parseInt( String.valueOf(eachCard.charAt(0)) ), String.valueOf(eachCard.charAt(1)) );
            }
        }

        return cardHashMap;

    }

//    public String findHighCard(String fiveCards) {
//        HashMap<Integer, String> cardsHashMap = putFiveCardsIntoHashMap(fiveCards);
//        List<>
//
//        return "";
//    }
}
