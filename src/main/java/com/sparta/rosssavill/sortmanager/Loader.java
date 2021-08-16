package com.sparta.rosssavill.sortmanager;

import com.sparta.rosssavill.sortmanager.questions.QuestionOne;
import com.sparta.rosssavill.sortmanager.questions.QuestionTwo;
import com.sparta.rosssavill.sortmanager.sorters.SortFactory;
import com.sparta.rosssavill.sortmanager.sorters.Sortable;
import com.sparta.rosssavill.sortmanager.util.Printer;
import com.sparta.rosssavill.sortmanager.util.RandomArrayGenerator;

import java.util.Scanner;

public class Loader {

    public void run() {
        QuestionOne questionOne = new QuestionOne();
        int arrayNumber = questionOne.questionOneMethod();

        QuestionTwo questionTwo = new QuestionTwo();
        int sortChoice = questionTwo.questionTwoMethod();

        int[] randomArray = RandomArrayGenerator.getRandomArray(arrayNumber);
        int[] randomArrayCopy = new int [randomArray.length];
        for(int i = 0; i < randomArray.length; i++) {
            randomArrayCopy[i] = randomArray[i];
        }

        Sortable chosenSort = SortFactory.getSorter(sortChoice);
        String className = chosenSort.getClass().getSimpleName();

        long startTime = System.nanoTime();
        int[] sortedArray = chosenSort.sort(randomArray);
        long endTime = System.nanoTime();
        long sortDuration = endTime - startTime;

        Printer printer = new Printer(randomArrayCopy, className, sortedArray, sortDuration);
        printer.printResult();
    }
}
