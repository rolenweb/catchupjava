package com.javalearning;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual interest rate: ");
        double annualInterestRare = scanner.nextFloat();

        System.out.print("Period years: ");
        byte period = scanner.nextByte();

        double monthlyInterestRate = annualInterestRare / PERCENT / MONTHS_IN_YEAR;
        double mortgage = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, period * MONTHS_IN_YEAR) / (Math.pow(1 + monthlyInterestRate, period * MONTHS_IN_YEAR) - 1));
        NumberFormat mortgageFormatted = NumberFormat.getCurrencyInstance();

        System.out.print("Mortgage: " + mortgageFormatted.format(mortgage));
    }
}
