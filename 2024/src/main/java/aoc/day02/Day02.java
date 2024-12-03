package aoc.day02;

import aoc.Day;
import aoc.Utils;

import java.util.List;

public class Day02 implements Day {

    @Override
    public String part1(String input) {
        List<String> lines = Utils.splitLines(input);
        return lines.isEmpty() ? "" : lines.getFirst();
    }

    @Override
    public String part2(String input) {
        return input;
    }

    public Boolean validateReport(int[] reportValues) {
        if(reportValues[0] > reportValues[1]) {
            // report is decreasing in value, so validate the decrease
            return checkDecrease(reportValues);
        } else if (reportValues[0] < reportValues[1]) {
            // report is increasing in value, so validate the increase
            return checkIncrease(reportValues);
        } else {
            // first two values are equal, so neither an increase nor decrease
            return false;
        }
    }

    // Check if the decrease in value is at a rate of 1, 2, or 3
    public boolean checkDecrease(int[] reportValues) {
        for (int i = 0; i < reportValues.length - 1; i++) {
            int difference = reportValues[i] - reportValues[i + 1];
            if (difference < 1 || difference > 3) {
                return false;
            }
        }
        return true;
    }

    // Check if the increase in value is at a rate of 1, 2, or 3
    public boolean checkIncrease(int[] reportValues) {
        for (int i = 0; i < reportValues.length - 1; i++) {
            int difference = reportValues[i + 1] - reportValues[i];
            if (difference < 1 || difference > 3) {
                return false;
            }
        }
        return true;
    }
}