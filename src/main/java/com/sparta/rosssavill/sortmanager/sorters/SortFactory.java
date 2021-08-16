package com.sparta.rosssavill.sortmanager.sorters;

import com.sparta.rosssavill.sortmanager.sorters.binarytree.BinaryTreeSort;

public class SortFactory {
    public static Sortable getSorter(int sorterNumber) {

        return switch (sorterNumber) {
            case 1 -> new BubbleSort();
            case 2 -> new BinaryTreeSort();
            case 3 -> new MergeSort();
            case 4 -> new InsertionSort();
            case 5 -> new QuickSort();
            case 6 -> new SelectionSort();
            case 7 -> new InbuiltJavaSort();
            default -> null;
        };
    }

}
