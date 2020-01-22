package BowlingTest;

import Bowling.Bowling;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingTest {


    private Bowling bowling;

    @Before
    public void setUp() throws Exception {
        bowling = new Bowling();
    }

    @Test
    public void testGutterGame() {
        rollMany(20,0);
        assertEquals(0,bowling.score());

    }

    @Test
    public void testAllOnes() {
        rollMany(20,1);
        assertEquals(20,bowling.score());
    }

    @Test
    public void testOneSpare() {
        rollSpare();
        bowling.roll(3);
        rollMany(17,0);
        assertEquals(16,bowling.score());
    }

    @Test
    public void testOneStrike() {
        rollStrike();
        bowling.roll(3);
        bowling.roll(4);
        rollMany(16,0);
        assertEquals(24,bowling.score());
    }

    private void rollStrike() {
        bowling.roll(10);
    }

    private void rollSpare() {
        bowling.roll(5);
        bowling.roll(5);
    }

    @Test
    public void testPerfectGame() {
        rollMany(12, 10);
        assertEquals(300,bowling.score());

    }


    public void rollMany(int n, int pins) {
        for (int i= 0;i< n;i++) {
            bowling.roll(pins);
        }
    }
}
