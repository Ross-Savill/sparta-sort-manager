package com.sparta.rosssavill.sortmanager.util;

import java.util.Arrays;

public class Printer {
    private final int[] randomArray;
    private final String sortName;
    private final int[] sortedArray;
    private final long sortDurationNanoSeconds;
    private final long sortDurationMilliSeconds;
    private final double sortDurationSeconds;



    public Printer(int[] randomArray, String className, int[] sortedArray, long sortDurationNanoSeconds) {
        this.randomArray = randomArray;
        this.sortName = className;
        this.sortedArray = sortedArray;
        this.sortDurationNanoSeconds = sortDurationNanoSeconds;
        this.sortDurationMilliSeconds = sortDurationNanoSeconds / 1000_000;
        this.sortDurationSeconds = sortDurationMilliSeconds / 1000.0;
    }

    public void printResult() {
        System.out.println("\n---------------------");
        System.out.println("Results:");
        System.out.println("---------------------");
        System.out.println("Chosen Sort: " + sortName);
        System.out.println("Array Pre-Sort: " + Arrays.toString(randomArray));
        System.out.println("Array Post-Sort: " + Arrays.toString(sortedArray));
        System.out.printf("Time Taken: " + sortDurationNanoSeconds + " nanoseconds " + "(Rounded to " + sortDurationMilliSeconds + " milliseconds or " + sortDurationSeconds + " seconds).\n");
        System.out.println("---------------------\n");

    }

}
