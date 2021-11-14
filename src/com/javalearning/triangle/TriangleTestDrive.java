package com.javalearning.triangle;

public class TriangleTestDrive {
    public static void main(String[] args) {
        Triangle[] triangles = new Triangle[4];
        int x = 0;
        while (x < 4) {
            triangles[x] = new Triangle();
            triangles[x].height = (x + 1) * 2;
            triangles[x].length = x + 4;
            System.out.print("triangle " + x + ", area");
            System.out.println(" = " + triangles[x].getAria());
            x++;
        }
    }
}
