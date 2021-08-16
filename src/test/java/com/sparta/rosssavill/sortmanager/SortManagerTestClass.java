package com.sparta.rosssavill.sortmanager;
import com.sparta.rosssavill.sortmanager.sorters.*;
import com.sparta.rosssavill.sortmanager.sorters.binarytree.BinaryTreeSort;
import com.sparta.rosssavill.sortmanager.util.RandomArrayGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortManagerTestClass {

    RandomArrayGenerator randomArrayGenerator = new RandomArrayGenerator();
    private final int[] randomArray = randomArrayGenerator.getRandomArray(50);

    @Test
    void checkBubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        boolean isBubbleSortWorking = SortedCheck.isSorted(bubbleSort.sort(randomArray));
        Assertions.assertEquals(true, isBubbleSortWorking);
    }

    @Test
    void checkBinaryTreeSort() {
        BinaryTreeSort binaryTreeSort = new BinaryTreeSort();
        boolean isBinaryTreeSortWorking = SortedCheck.isSorted(binaryTreeSort.sort(randomArray));
        Assertions.assertEquals(true, isBinaryTreeSortWorking);
    }

    @Test
    void checkInsertionSort() {
        InsertionSort insertionSort = new InsertionSort();
        boolean isInsertionSortWorking = SortedCheck.isSorted(insertionSort.sort(randomArray));
        Assertions.assertEquals(true, isInsertionSortWorking);
    }

    @Test
    void checkMergeSort() {
        MergeSort mergeSort = new MergeSort();
        boolean isMergeSortWorking = SortedCheck.isSorted(mergeSort.sort(randomArray));
        Assertions.assertEquals(true, isMergeSortWorking);
    }

    @Test
    void checkQuickSort() {
        QuickSort quickSort = new QuickSort();
        boolean isQuickSortWorking = SortedCheck.isSorted(quickSort.sort(randomArray));
        Assertions.assertEquals(true, isQuickSortWorking);
    }

    @Test
    void checkSelectionSort() {
        SelectionSort selectionSort = new SelectionSort();
        boolean isSelectionSortWorking = SortedCheck.isSorted(selectionSort.sort(randomArray));
        Assertions.assertEquals(true, isSelectionSortWorking);
    }

    @Test
    void checkGetNumberOfElements() {
        BinaryTreeSort binaryTreeSort = new BinaryTreeSort();
        binaryTreeSort.sort(randomArray);
        int arrayLength = randomArray.length;
        int nodeNumber = binaryTreeSort.getNumberOfElements();
        Assertions.assertEquals(arrayLength, nodeNumber);
    }

    @Test
    void checkGetRootElement() {
        BinaryTreeSort binaryTreeSort = new BinaryTreeSort();
        binaryTreeSort.sort(randomArray);
        int firstValue = randomArray[0];
        int rootNodeValue = binaryTreeSort.getRootElement();
        Assertions.assertEquals(rootNodeValue, firstValue);
    }
}
