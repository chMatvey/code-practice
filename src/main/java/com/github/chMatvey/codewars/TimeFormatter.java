package com.github.chMatvey.codewars;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TimeFormatter {
    @AllArgsConstructor
    enum TimeInfo {
        SECOND("second", 60),
        MINUTE("minute", 60),
        HOUR("hour", 24),
        DAY("day", 365),
        YEAR("year", 1);

        final String name;
        final int divider;
    }

    public static String formatDuration(int seconds) {
        if (seconds < 0) throw new IllegalArgumentException("Seconds must be positive");

        List<String> result = new ArrayList<>();
        int units = seconds;
        for (TimeInfo info : TimeInfo.values()) {
            int current = info.divider != 1 ? units % info.divider : units;
            units = units / info.divider;
            if (current == 1) {
                result.add(0, current + " " + info.name);
            } else if (current > 1) {
                result.add(0, current + " " + info.name + "s");
            }
            if (units == 0) break;
        }
        if (result.isEmpty()) {
            return "now";
        } else if (result.size() == 1) {
            return result.get(0);
        } else {
            int secondLastIndex = result.size() - 2;
            List<String> twoLastList = result.subList(secondLastIndex, result.size());
            String twoLast = twoLastList.get(0) + " and " + twoLastList.get(1);
            List<String> others = result.subList(0, secondLastIndex);

            return others.isEmpty() ? twoLast : String.join(", ", others) + ", " + twoLast;
        }
    }
}
