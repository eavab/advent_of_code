package aoc.day02;

import aoc.Utils;
import aoc.day01.Day01;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class Day02Test {

    @Test
    void testPart1Sample() {
        Utils utils = new Utils();
        Day02 day02 = new Day02();

        List<int[]> tokens = new ArrayList<>();

        utils.getInputLinesByLine(line-> tokens.add(utils.tokenize(line, 5)), "day02/sample.txt");

        int safeReportCount = 0;

        for(int[] token : tokens) {
            if(day02.validateReport(token)) {
                safeReportCount++;
            }
        }

        log.info("safeReportCount: {}", safeReportCount);
        assertEquals(2, safeReportCount);
    }

    @Test
    void testPart1(){
        // Given
        String input = "test";

        // When
        String result = new Day01().part1(input);

        // Then
        assertEquals(input, result);
        log.info("Part 1 Success");
    }

    @Test
    void testPart2(){
        // Given
        String input = "test";

        // When
        String result = new Day01().part2(input);

        // Then
        assertEquals(input, result);
        log.info("Part 2 Success");
    }
}