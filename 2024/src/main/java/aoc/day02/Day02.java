package aoc.day02;

import aoc.Day;
import aoc.Utils;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
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
        if (reportValues.length < 2) {
            log.debug("Base case reached with reportValues: {} | Returning true.", Arrays.toString(reportValues));
            return true;
        }

        boolean isIncreasing = reportValues[1] > reportValues[0];
        boolean isValid = checkTrendConsistency(reportValues, isIncreasing);

        log.debug("Validating sequence: {} | Dampener: {} | Failure: {} | Initial trend: {}",
                Arrays.toString(reportValues), problemDampener, failureOccurred, isIncreasing ? "increasing" : "decreasing");

        if (!isValid) {
            if (Boolean.FALSE.equals(problemDampener)) {
                log.debug("Validation failed without dampener for sequence: {}", Arrays.toString(reportValues));
                return false;
            }
            if (Boolean.TRUE.equals(failureOccurred)) {
                log.debug("Validation failed with dampener already triggered for sequence: {}", Arrays.toString(reportValues));
                return false;
            }

            // Apply dampener: drop the problematic index and revalidate
            log.debug("Validation failed, applying dampener and dropping problematic index.");
            int problematicIndex = findProblematicIndex(reportValues);
            log.debug("Problematic index found at: {}", problematicIndex);

            if (problematicIndex >= 0) {
                int[] newReportValues = createArrayWithoutIndex(reportValues, problematicIndex);
                log.debug("New sequence after dropping index {}: {}", problematicIndex, Arrays.toString(newReportValues));
                return validateReportRecursive(newReportValues, false, true);  // Recurse without dampener
            } else {
                log.debug("No problematic index found. Returning true.");
                return true;
            }
        }

        return true;
    }

    // Helper method to remove an element from the array
    private int[] createArrayWithoutIndex(int[] original, int indexToRemove) {
        int[] newArray = new int[original.length - 1];
        for (int i = 0, j = 0; i < original.length; i++) {
            if (i != indexToRemove) {
                newArray[j++] = original[i];
            }
        }
        return newArray;
    }

    // New helper method to find the problematic index
    private int findProblematicIndex(int[] reportValues) {
        // This method should find the first index where the trend is inconsistent
        for (int i = 1; i < reportValues.length; i++) {
            int diff = Math.abs(reportValues[i] - reportValues[i - 1]);
            if (diff < 1 || diff > 3 || reportValues[i] <= reportValues[i - 1]) {
                log.debug("Problematic index at {}: {}. Inconsistent trend detected.", i, reportValues[i]);
                return i;  // Return the index where the inconsistency occurs
            }
        }
        return -1;  // No inconsistency found
    }

    private boolean checkTrendConsistency(int[] reportValues, boolean isIncreasing) {
        for (int i = 1; i < reportValues.length; i++) {
            int diff = Math.abs(reportValues[i] - reportValues[i - 1]);
            if (diff < 1 || diff > 3 || (isIncreasing && reportValues[i] <= reportValues[i - 1]) ||
                    (!isIncreasing && reportValues[i] >= reportValues[i - 1])) {
                log.debug("Trend inconsistency detected at index {} for sequence: {}", i, Arrays.toString(reportValues));
                return false;
            }
        }
        return true;
    }

    // Check if the decrease in value is at a rate of 1, 2, or 3
    public boolean checkDecrease(int[] reportValues) {
        int difference = reportValues[0] - reportValues[1];
        return difference >= 1 && difference <= 3 && reportValues[0] > reportValues[1]; // Strictly decreasing
    }

    public boolean checkIncrease(int[] reportValues) {
        int difference = reportValues[1] - reportValues[0];
        return difference >= 1 && difference <= 3 && reportValues[1] > reportValues[0]; // Strictly increasing
    }
}