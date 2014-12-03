package hu.tigra.tutorial.epi;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LimitCalculationTest {

    LimitCalculation calculation;

    @Before
    public void setUp() throws Exception {
        calculation = new LimitCalculation();
    }

    @Test
    public void testCalculateLimit50() throws Exception {
        int limit = calculation.calculateLimit(50);
        assert limit < 33;
        assert limit > 2;
    }

    @Test
    public void testCalculateLimit75() throws Exception {
        int limit = calculation.calculateLimit(75);
        assert limit <= 68;
        assert limit > 52;
    }

    @Test
    public void testCalculateLimit40and75() throws Exception {
        int limit = calculation.calculateLimit(39, 75);
        assert limit <= 39;
        assert limit > 20;
    }
}