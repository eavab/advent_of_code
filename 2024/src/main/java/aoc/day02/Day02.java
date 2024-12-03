package aoc.day02;

import aoc.Day;
import aoc.Utils;

import java.util.Arrays;
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

    public Boolean validateReport(int[] reportValues, Boolean problemDampener) {
        return validateReportRecursive(reportValues, problemDampener, false);
    }

    private Boolean validateReportRecursive(int[] reportValues, Boolean problemDampener, Boolean failureOccurred) {
        // Base case: If there are fewer than two values left, validation is complete
        if (reportValues.length < 2) {
            return true;
        }

        boolean isDecreasing = reportValues[0] > reportValues[1];
        boolean isIncreasing = reportValues[0] < reportValues[1];

        if (isDecreasing) {
            if (!checkDecrease(reportValues)) {
                if (failureOccurred || !problemDampener) {
                    return false; // Fail if a failure already occurred or dampener is off
                }
                // Allow one failure and skip the problematic value
                return validateReportRecursive(new int[]{reportValues[0], reportValues[2]}, problemDampener, true);
            }
        } else if (isIncreasing) {
            if (!checkIncrease(reportValues)) {
                if (failureOccurred || !problemDampener) {
                    return false; // Fail if a failure already occurred or dampener is off
                }
                // Allow one failure and skip the problematic value
                return validateReportRecursive(new int[]{reportValues[0], reportValues[2]}, problemDampener, true);
            }
        } else {
            return false; // Equal values are invalid
        }

        // Move to the next pair for validation
        return validateReportRecursive(Arrays.copyOfRange(reportValues, 1, reportValues.length), problemDampener, failureOccurred);
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