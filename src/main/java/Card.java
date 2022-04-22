public class Card {
    private int value;
    private char suit;

    public Card() {
    }

    public Card(int value, char suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public char getSuit() {
        return suit;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }

    public String getCardValueToString() {
        if(this.getValue() == 11) {
            return "Jack";
        } else if (this.getValue() == 12){
            return "Queen";
        } else if (this.getValue() == 13) {
            return "King";
        } else if (this.getValue() == 14) {
            return "Ace";
        }
        return String.valueOf(this.getValue());
    }

}
