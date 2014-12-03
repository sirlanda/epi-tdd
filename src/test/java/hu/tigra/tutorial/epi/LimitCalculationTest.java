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
    public void testCalculateLimit() throws Exception {
        int limit = calculation.calculateLimit(50);
        assert limit < 33;
        assert limit > 2;
    }
}