public class Poker {

    public String compareSimpleNumbers(int black, int white) {
        if(black > white) {
            return "Black wins. - with high card: " + black;
        } else {
            return "White wins. - with high card: " + white;
        }
    }
}
