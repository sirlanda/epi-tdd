package hu.tigra.tutorial.epi;

import org.apache.commons.math3.stat.descriptive.moment.Mean;

/**
 * It is an old wisdom that the average of written exams
 * must be between {@link java.lang.Math#E E} (~2.71)
 * and {@link java.lang.Math#PI PI} (~3.14).
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
