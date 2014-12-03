package hu.tigra.tutorial.epi;

import org.apache.commons.math3.stat.descriptive.moment.Mean;

/**
 * It is an old wisdom that the average of written exams
 * must be between {@link java.lang.Math#E E} (~2.71)
 * and {@link java.lang.Math#PI PI} (~3.14).
 */
public class LimitCalculation {

    public int calculateLimit(int... points) {
        double mean = 0.0;
        int oldLimit = 0;
        int limit = 50;
        double[] marks = new double[points.length];

        while ((mean < Math.E) || (mean > Math.PI)) {
            for (int i = 0; i < points.length; i++) {
                marks[i] = 0.0 + getMark(limit, points[i]);
            }

            mean = new Mean().evaluate(marks, 0, marks.length);

            int tmpLimit = limit;
            if (mean < Math.E) {
                limit = limit - (Math.abs(limit - oldLimit)) / 2;
            } else if (mean > Math.PI) {
                limit = limit + (Math.abs(limit - oldLimit)) / 2;
            }
            oldLimit = tmpLimit;
        }
        return limit;
    }

    private int getMark(int limit, int point) {
        if (limit > point)
            return 1;
        else if (limit + (100 - limit)/4 > point)
            return 2;
        else if (limit + (100 - limit)/2 > point)
            return 3;
        else if (limit + (100 - limit)/4*3 > point)
            return 4;
        else
            return 5;
    }
}
