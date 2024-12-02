package aoc.day01;

import aoc.Utils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class Day01Test {

    @Test
    void testPart0() {

        Utils utils = new Utils();

        List<int[]> tokens = new ArrayList<>();

        utils.getInputLinesByLine(line-> tokens.add(utils.tokenize(line)), "day01/sample.txt");

        List<String> leftList = new ArrayList<>();
        List<String> rightList = new ArrayList<>();

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