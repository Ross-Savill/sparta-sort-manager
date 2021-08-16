package com.sparta.rosssavill.sortmanager.sorters;

public class BubbleSort implements Sortable {

    @Override
    public int[] sort(int[] arrayToSort) {
        return sortArray(arrayToSort);
    }

    public int[] sortArray(int[] randomArray) {
        int arrLength = randomArray.length;
        for(int i=0; i < arrLength; i++) {
            for (int j=0; j < arrLength - i - 1; j++) { // j = i
                if(randomArray[j] > (randomArray[j+1])) {
                    int holdNum = randomArray[j];
                    randomArray[j] = randomArray[j+1];
                    randomArray[j+1] = holdNum;
                }
            }
        }
        return randomArray;
    }
}
