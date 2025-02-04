package aoc.day02;

import aoc.Utils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
class Day02Test {

    @Test
    void testPart1Sample() {
        Utils utils = new Utils();
        Day02 day02 = new Day02();

        List<int[]> tokens = new ArrayList<>();
        utils.getInputLinesByLine(line -> tokens.add(utils.tokenize(line)), "day02/sample.txt");

        int safeReportCount = 0;

        for (int[] token : tokens) {
            boolean isSafe = day02.validateReport(token, false);
            if (isSafe) {
                log.info("Token {} classified as Safe due to recursive validation.", Arrays.toString(token));
                safeReportCount++;
            } else {
                log.info("Token {} classified as Unsafe due to recursive validation.", Arrays.toString(token));
            }
        }

        log.info("safeReportCount: {}", safeReportCount);
        Assertions.assertEquals(2, safeReportCount);
    }

    @Test
    void testPart2Sample() {
        Utils utils = new Utils();
        Day02 day02 = new Day02();

        List<int[]> tokens = new ArrayList<>();

        utils.getInputLinesByLine(line-> tokens.add(utils.tokenize(line)), "day02/sample.txt");

        int safeReportCount = 0;

        for(int[] token : tokens) {
            if(day02.validateReport(token, true)) {
                log.info("checking token {} -- Safe", token);
                safeReportCount++;
            } else {
                log.info("checking token {} -- Unsafe", token);

            }
        }

        log.info("safeReportCount: {}", safeReportCount);
        Assertions.assertEquals(4, safeReportCount);
    }

    @Test
    void testPart1(){
        Utils utils = new Utils();
        Day02 day02 = new Day02();

        List<int[]> tokens = new ArrayList<>();

        utils.getInputLinesByLine(line-> tokens.add(utils.tokenize(line)), "day02/part1.txt");

        int safeReportCount = 0;

        for(int[] token : tokens) {
            if(day02.validateReport(token, false)) {
                safeReportCount++;
            }
        }

        log.info("safeReportCount: {}", safeReportCount);
        Assertions.assertEquals(670, safeReportCount);
    }

    // TODO: update the algorithm to actually clone the int[] and remove the value and pass to algorithm for second check instead of getting clever for comparison positions
    @Test
    void testPart2(){
        Utils utils = new Utils();
        Day02 day02 = new Day02();

        List<int[]> tokens = new ArrayList<>();

        utils.getInputLinesByLine(line-> tokens.add(utils.tokenize(line)), "day02/part1.txt");

        int safeReportCount = 0;

        for(int[] token : tokens) {
            if(day02.validateReport(token, true)) {
                safeReportCount++;
            }
        }

        log.info("safeReportCount: {}", safeReportCount);

        // not an exact result, still narrowing it down
        assert(safeReportCount < 626);
    }
}