package aoc.day03;

import aoc.day01.Day01;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class Day03Test {

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