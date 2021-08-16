package com.sparta.rosssavill.sortmanager.sorters;

public class SelectionSort implements Sortable {

    @Override
    public int[] sort(int[] arrayToSort) {
        selectionSort(arrayToSort);
        return arrayToSort;
    }

    void selectionSort(int[] arrayToSort) {

        int arrayLen = arrayToSort.length;

        for (int outerIdx = 0; outerIdx < arrayLen - 1; outerIdx++) {
            int smallestNumIdx = outerIdx;
            for (int innerIdx = outerIdx + 1; innerIdx < arrayLen; innerIdx++)
                if (arrayToSort[innerIdx] < arrayToSort[smallestNumIdx]) {
                    smallestNumIdx = innerIdx;
                }

            int temp = arrayToSort[smallestNumIdx];
            arrayToSort[smallestNumIdx] = arrayToSort[outerIdx];
            arrayToSort[outerIdx] = temp;
        }
    }
}
