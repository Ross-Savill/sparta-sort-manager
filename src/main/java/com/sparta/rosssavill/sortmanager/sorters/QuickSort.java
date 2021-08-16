package com.sparta.rosssavill.sortmanager.sorters;

public class QuickSort implements Sortable {

    @Override
    public int[] sort(int[] arrayToSort) {
        quickSort(arrayToSort, 0, arrayToSort.length - 1);
        return arrayToSort;
    }

    private void quickSort(int[] arrayToSort, int lowerIndex, int upperIndex) {
        int ascendingIdx = lowerIndex;
        int descendingIdx = upperIndex;
        int pivot = arrayToSort[lowerIndex + (upperIndex-lowerIndex)/2];

        while(ascendingIdx <= descendingIdx) {
            while(arrayToSort[ascendingIdx] < pivot) {
                ascendingIdx++;
            }
            while(arrayToSort[descendingIdx] > pivot) {
                descendingIdx--;
            }
            if (ascendingIdx <= descendingIdx) {
                swapNums(arrayToSort, ascendingIdx, descendingIdx);
                ascendingIdx++;
                descendingIdx--;
            }
        }
        if (lowerIndex < descendingIdx)
            quickSort(arrayToSort, lowerIndex, descendingIdx);
        if (ascendingIdx < upperIndex)
            quickSort(arrayToSort, ascendingIdx, upperIndex);
    }

    private void swapNums(int[] arrayToSort, int smallerNum, int largerNum) {
        int tempHolder = arrayToSort[smallerNum];
        arrayToSort[smallerNum] = arrayToSort[largerNum];
        arrayToSort[largerNum] = tempHolder;
    }

}
