package me.eyal.triangle;

import java.util.Scanner;

/**
 * Solving pyramid patterns...
 */
public class Main {
    private static long startTime = System.currentTimeMillis();

    public static void main(String[] args) {
        Main main = new Main();
        System.out.print("Enter number of rows for pascal triangle: ");
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        main.printPascalTriangle(rows);
        System.out.println();
        System.out.print("Enter number of rows for ABC triangle: ");
        rows = sc.nextInt();
        main.printABCTriangle(rows);
        System.out.println();
        System.out.print("Enter number of rows for mirror triangle: ");
        rows = sc.nextInt();
        main.printMirrorTriangle(rows);
        System.out.println();
        System.out.println("Process Time: " + main.formatMils(startTime, System.currentTimeMillis()));
    }

    private void printPascalTriangle(int rows) {
        System.out.println("PASCAL TRIANGLE:\n");

        // i: Rows index...
        for (int i = 0; i < rows; i++) {
            // Printing spacers...
            for (int spaces = 0; spaces < rows - i; spaces++) {
                System.out.print(" ");
            }
            // Calculating the number based on row's index.
            for (int j = 0; j <= i; j++) {
                System.out.print(" " + calcPascalValue(i, j));
            }
            System.out.println();
        }

    }

    private void printABCTriangle(int rows) {
        byte ch = (byte) 'A';

        for (int i = 0; i < rows; i++) {
            for (int spaces = 0; spaces < rows - i; spaces++) {
                System.out.print(" ");
            }
            if(i != 1) {
                for (int j = i - 1; j > 0; j--) {
                    System.out.print((char) ch);
                    ch++;
                }
                for (int j = i; j > 0; j--) {
                    System.out.print((char) ch);
                    ch--;
                }
            } else {
                System.out.print((char) ch);
            }
            ch = (byte) 'A';
            System.out.println();
        }
    }

    private void printMirrorTriangle(int rows) {
        for (int i = 0; i <= rows; i++) {
            for (int spaces = rows - i; spaces > 0; spaces--) {
                System.out.print(" ");
            }
            for (int j = i; j > 0; j--) {
                System.out.print(j);
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int spaces = 0; spaces < rows - i; spaces++) {
                System.out.print(" ");
            }
            for (int j = i; j > 0; j--) {
                System.out.print(j);
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    private long calcPascalValue(int row, int index) {
        return (index == 0 || index == row) ? 1 : calcPascalValue(row - 1, index - 1) + calcPascalValue(row - 1, index);
    }

    private String formatMils(long a, long b) {
        double seconds = (b - a) / 1000.0;
        return String.valueOf(seconds);
    }
}
