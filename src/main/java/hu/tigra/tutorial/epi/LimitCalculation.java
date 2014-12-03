package hu.tigra.tutorial.epi;

import org.apache.commons.math3.stat.descriptive.moment.Mean;

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
        int oldLimit = 0;
        int limit = 48;
        double[] marks = new double[points.length];

        while (limit != oldLimit) {
            for (int i = 0; i < points.length; i++) {
                marks[i] = 0.0 + getMark(limit, points[i]);
            }

            final double mean = new Mean().evaluate(marks, 0, marks.length);

            int tmpLimit = limit;
            if (mean < Math.E) {
                limit = limit - getHalfOfInterval(oldLimit, limit);
                limit += limit % 4;
            } else if (mean > Math.PI) {
                limit = limit + getHalfOfInterval(oldLimit, limit);
                limit -= limit % 4;
            }
            oldLimit = tmpLimit;
        }
        return limit;
    }

    private int getHalfOfInterval(int oldLimit, int limit) {
        return (Math.abs(limit - oldLimit)) / 2;
    }

    private int getMark(int limit, int point) {
        if (limit > point)
            return 1;
        else {
            final int div = (100 - limit) / 4;

            return div == 0
                    ? 5
                    : (point - limit) / div + 2;
        }
    }
}
