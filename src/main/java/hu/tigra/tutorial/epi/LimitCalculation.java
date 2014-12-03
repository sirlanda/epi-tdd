package hu.tigra.tutorial.epi;

/**
 * It is an ancient wisdom that the average of written exams
 * must be between {@link java.lang.Math#E E} (~2.71)
 * and {@link java.lang.Math#PI PI} (~3.14).
 *
 * The maximum points should be 100.
 * The marks are 1, 2, 3, 4 and 5, where 1 is the inadequate result
 * and 5 is the best.
 *
 * The limit for pass mark should be calculated to get the expected
 * average of marks. While the further partitioning should be equal
 * for 2, 3, 4 and 5. Eg. 48, 61, 74, 87 can be a proper partitioning.
 */
public class LimitCalculation {

    public int calculateLimit(int... points) {
        return 110;
    }
}
