package main.java.aoc.day01;

import main.java.aoc.Day;
import main.java.aoc.Utils;

import java.util.List;

public class Day01 implements Day {

    @Override
    public String part1(String input) {
        List<String> lines = Utils.splitLines(input);
        return lines.isEmpty() ? "" : lines.get(0);
    }

    @Override
    public String part2(String input) {
        return input;
    }

}