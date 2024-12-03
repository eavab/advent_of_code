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
    void testPart1Sample() {
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
        assertEquals(11, sumOfDifference);
    }

    @Test
    void testPart2Sample() {
        // https://adventofcode.com/2024/day/1/input
        Utils utils = new Utils();

        List<int[]> tokens = new ArrayList<>();

        utils.getInputLinesByLine(line-> tokens.add(utils.tokenize(line)), "day01/sample.txt");

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        List<Integer> similarityList = new ArrayList<>();

        // split the list in two
        for(int[] token : tokens) {
            leftList.add(token[0]);
            rightList.add(token[1]);
        }

        // sort both lists in ascending order
        leftList.sort(Integer::compareTo);
        rightList.sort(Integer::compareTo);

        int numOfSimilarity = 0;

        // build the list of differences
        for (Integer value : leftList) {
            for (Integer integer : rightList) {
                if (value.equals(integer)) {
                    numOfSimilarity++;
                }
            }

            similarityList.add(numOfSimilarity * value);
            numOfSimilarity = 0;
        }

        int sumOfDifference = similarityList.stream().mapToInt(Integer::intValue).sum();

        log.info(Integer.toString(sumOfDifference));
        assertEquals(31, sumOfDifference);
    }

    // calculate the difference between each number
    @Test
    void testPart1(){
        // https://adventofcode.com/2024/day/1/input
        Utils utils = new Utils();

        List<int[]> tokens = new ArrayList<>();

        utils.getInputLinesByLine(line-> tokens.add(utils.tokenize(line)), "day01/part1.txt");

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
    }

    // calculate the "similarity" for each number
    @Test
    void testPart2(){
        // https://adventofcode.com/2024/day/1/input
        Utils utils = new Utils();

        List<int[]> tokens = new ArrayList<>();

        utils.getInputLinesByLine(line-> tokens.add(utils.tokenize(line)), "day01/part1.txt");

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        List<Integer> similarityList = new ArrayList<>();

        // split the list in two
        for(int[] token : tokens) {
            leftList.add(token[0]);
            rightList.add(token[1]);
        }

        // sort both lists in ascending order
        leftList.sort(Integer::compareTo);
        rightList.sort(Integer::compareTo);

        int numOfSimilarity = 0;

        // build the list of differences
        for (Integer value : leftList) {
            for (Integer integer : rightList) {
                if (value.equals(integer)) {
                    numOfSimilarity++;
                }
            }

            similarityList.add(numOfSimilarity * value);
            numOfSimilarity = 0;
        }

        int sumOfDifference = similarityList.stream().mapToInt(Integer::intValue).sum();

        log.info(Integer.toString(sumOfDifference));
    }
}