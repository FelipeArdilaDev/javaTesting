package player;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void losesWhenDiceNumberIsTooLow() {

        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(2);

        Player player = new Player(dice, 3);
        assertFalse(player.play());
    }

    @Test
    public void WinsWhenDiceNumberIsBig() {

        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(4);

        Player player = new Player(dice, 3);
        assertTrue(player.play());
    }
}