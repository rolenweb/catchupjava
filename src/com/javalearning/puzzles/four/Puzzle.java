package com.javalearning.puzzles.four;

public class Puzzle {
    int ivar;

    public int doStuff(int factor) {
        if (ivar > 100)
            return ivar * factor;
        else
            return ivar * (5 - factor);
    }
}
