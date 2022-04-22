import java.util.ArrayList;
import java.util.HashMap;

public class Poker {
    private static final Integer JACK = 11;
    private static final Integer QUEEN = 12;
    private static final Integer KING = 13;
    private static final Integer ACE = 14;

    private static final String BLACK_WIN = "Black wins. ";
    private static final String WHITE_WIN = "White wins. ";

    private static final String HIGH_CARD = "high card: ";

    private String output = "";

    private Card highCardBlack = new Card();
    private Card highCardWhite = new Card();


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

    // change J,Q,K,A to integer values
    // put each card to Card Class instance
    // add each Card instance to ArrayList
    public ArrayList<Card> changeCardsInputStringToArrayList(String fiveCards) {
        ArrayList<Card> cardList = new ArrayList<>();

        for( String eachCard : fiveCards.split(" ") ) {
            if(eachCard.charAt(0) == 'J') {
                cardList.add(new Card (JACK, eachCard.charAt(1)) );
            } else if(eachCard.charAt(0) == 'Q') {
                cardList.add(new Card (QUEEN, eachCard.charAt(1)) );
            } else if(eachCard.charAt(0) == 'K') {
                cardList.add(new Card (KING, eachCard.charAt(1)) );
            } else if(eachCard.charAt(0) == 'A') {
                cardList.add(new Card (ACE, eachCard.charAt(1)) );
            } else {
                cardList.add( new Card(Character.getNumericValue(eachCard.charAt(0)), eachCard.charAt(1) ) );
            }
        }

        return cardList;
    }

    public Card findHighCard(ArrayList<Card> cardList) {
        Card highCard = new Card();
        highCard.setValue(0);

        for(Card card : cardList) {
            if(highCard.getValue() < card.getValue()) {
                highCard = card;
            }
        }

        return highCard;
    }

    public String getBlackCardInputString(String userInputString) {
        String[] userInputStringArray = userInputString.split("  ");
        String black = userInputStringArray[0].substring(7);

        return black;
    }

    public String getWhiteCardInputString(String userInputString) {
        String[] userInputStringArray = userInputString.split("  ");
        String white = userInputStringArray[1].substring(7);

        return white;
    }

    public ArrayList<Card> getBlackCardListFromUserInput(String userInputString) {
        return changeCardsInputStringToArrayList(getBlackCardInputString(userInputString));
    }

    public ArrayList<Card> getWhiteCardListFromUserInput(String userInputString) {
        return changeCardsInputStringToArrayList(getWhiteCardInputString(userInputString));
    }

    public String decideWinner(String userInputString) {
        ArrayList<Card> cardListBlack = getBlackCardListFromUserInput(userInputString);
        ArrayList<Card> cardListWhite = getWhiteCardListFromUserInput(userInputString);

        return decideHighCardWinner(cardListBlack, cardListWhite);
    }

   public String decideHighCardWinner(ArrayList<Card> cardListBlack, ArrayList<Card> cardListWhite) {
       highCardBlack = findHighCard(cardListBlack);
       highCardWhite = findHighCard(cardListWhite);

       if (highCardBlack.getValue() > highCardWhite.getValue()) {
           output = BLACK_WIN + "- with " + HIGH_CARD + highCardBlack.getCardValueToString();
       } else if (highCardBlack.getValue() < highCardWhite.getValue()) {
           output = WHITE_WIN + "- with " + HIGH_CARD + highCardWhite.getCardValueToString();
       } else { // if the high card of both have the same value, ranked by the next highest, and so on.
           while(!cardListBlack.isEmpty() && output == "") {
               cardListBlack.remove(highCardBlack);
               cardListWhite.remove(highCardWhite);

               output = decideHighCardWinner(cardListBlack, cardListWhite);
           }
       }

       return output;
   }


}
