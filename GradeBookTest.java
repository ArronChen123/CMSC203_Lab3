package application;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit 4 tests for GradeBook — CMSC203 Lab 3
 */
public class GradeBookTest {

    private GradeBook g1;
    private GradeBook g2;

    @Before
    public void setUp() {
        g1 = new GradeBook(5);
        g1.addScore(50.0);
        g1.addScore(75.0);

        g2 = new GradeBook(5);
        g2.addScore(85.0);
        g2.addScore(92.0);
        g2.addScore(76.5);
        g2.addScore(88.5);
    }

    @After
    public void tearDown() {
        g1 = null;
        g2 = null;
    }

    @Test
    public void testAddScore() {
        assertEquals("50.0 75.0 ", g1.toString());
        assertEquals(2, g1.getScoreSize());

        assertEquals("85.0 92.0 76.5 88.5 ", g2.toString());
        assertEquals(4, g2.getScoreSize());
    }

    @Test
    public void testSum() {
        assertEquals(125.0, g1.sum(), 0.0001);
        assertEquals(342.0, g2.sum(), 0.0001);
    }

    @Test
    public void testMinimum() {
        assertEquals(50.0, g1.minimum(), 0.0001);
        assertEquals(76.5, g2.minimum(), 0.0001);
    }

    @Test
    public void testFinalScore() {
        assertEquals(75.0, g1.finalScore(), 0.0001);
        assertEquals(265.5, g2.finalScore(), 0.0001);
    }

    @Test
    public void testGetScoreSize() {
        GradeBook small = new GradeBook(3);
        small.addScore(80.0);
        small.addScore(90.0);
        small.addScore(70.0);
        assertEquals(3, small.getScoreSize());
        assertFalse(small.addScore(95.0));
    }
}
