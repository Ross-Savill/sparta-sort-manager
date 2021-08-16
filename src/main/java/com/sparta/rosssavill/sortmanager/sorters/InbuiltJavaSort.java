package com.sparta.rosssavill.sortmanager.sorters;

import java.util.Arrays;

public class InbuiltJavaSort implements Sortable {

    @Override
    public int[] sort(int[] arrayToSort) {
        Arrays.sort(arrayToSort);
        return arrayToSort;
    }
}
