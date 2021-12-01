package com.javalearning.clowns;

public class ClownsTestDrive extends Clowns {
    public static void main(String[] args) {
        Nose[] i = new Nose[3];
        i[0] = new Acts();
        i[1] = new Clowns();
        i[2] = new ClownsTestDrive();
        for (int j = 0; j < 3; j++) {
            System.out.println(i[j].iMethod() + " " + i[j].getClass());
        }
    }
}
