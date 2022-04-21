import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PokerGameTest {

    @Test
    public void compareSimpleNumbersTest() {
        Poker poker = new Poker();

        String expected = "White wins. - with high card: 3";
        String actual = poker.compareSimpleNumbers(2, 3);

        Assertions.assertEquals(expected, actual);

    }
}
