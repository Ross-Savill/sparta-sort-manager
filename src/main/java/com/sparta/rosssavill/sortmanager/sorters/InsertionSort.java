package com.sparta.rosssavill.sortmanager.sorters;

public class InsertionSort implements Sortable {

    @Override
    public int[] sort(int[] arrayToSort) {
        insertionSort(arrayToSort);
        return arrayToSort;
    }

    void insertionSort(int arrayToSort[])
    {
        for (int i = 1; i < arrayToSort.length; ++i) {
            int intInFront = arrayToSort[i];
            int positionToCheck = i - 1;

            while (positionToCheck >= 0 && arrayToSort[positionToCheck] > intInFront) {
                arrayToSort[positionToCheck + 1] = arrayToSort[positionToCheck];
                positionToCheck = positionToCheck - 1;
            }
            arrayToSort[positionToCheck + 1] = intInFront;
        }
    }
}
