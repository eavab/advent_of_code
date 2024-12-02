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

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        List<Integer> differenceList = new ArrayList<>();

        // split the list in two
        for(int[] token : tokens) {
            leftList.add(token[0]);
            rightList.add(token[1]);
        }

        // sort both lists in ascending order
        leftList.sort(Integer::compareTo);
        rightList.sort(Integer::compareTo);

        // build the list of differences
        for(int i = 0; i < leftList.size(); i++) {
            differenceList.add(Math.abs(leftList.get(i) - rightList.get(i)));
        }

        int sumOfDifference = differenceList.stream().mapToInt(Integer::intValue).sum();

        log.info(Integer.toString(sumOfDifference));
        assertEquals(sumOfDifference, 11);
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