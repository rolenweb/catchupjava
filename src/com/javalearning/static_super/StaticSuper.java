package com.javalearning.static_super;

public class StaticSuper {
    static {
        System.out.println("super static block");
    }

    StaticSuper() {
        System.out.println("super constructor");
    }
}


