package com.javalearning.puzzles.four;

public class PuzzleTestDrive {
    public static void main(String[] args) {
        Puzzle[] puzzles = new Puzzle[6];

        int y = 1;
        int x = 0;
        int result = 0;
        while (x < 6) {
            puzzles[x] = new Puzzle();
            puzzles[x].ivar = y;
            y = y * 10;
            x++;
        }
        x = 6;
        while (x > 0) {
            x--;
            result = result + puzzles[x].doStuff(x);
        }

        System.out.println("result " + result);
    }
}
