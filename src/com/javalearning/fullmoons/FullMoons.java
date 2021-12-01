package com.javalearning.fullmoons;
import java.util.Calendar;

import static java.lang.System.out;

public class FullMoons {
    static int DAY_IM = 1000 * 60 * 60 * 24;

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(2004, 0, 7, 15, 40);
        for (int i = 0; i < 60; i++) {
            out.printf("full moon on %tc%n", calendar);

            long day1 = calendar.getTimeInMillis();
            day1 += DAY_IM * 29.52;
            calendar.setTimeInMillis(day1);
        }
    }
}
