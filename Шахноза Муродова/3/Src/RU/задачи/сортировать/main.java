package ru.tasks.sort;

import java.util.Arrays;
import java.util.Random;

public class Main {
 
    public static void main(String [] args) {
        int [][] array1 = {
                {9, 0, -2, 89, 1, 2, 3, -3, -99, 6},
                {5, 3, 1, 2, 2, 1, 0},
                {1, 1},
                {3, 1, 1},
                {2, 1, 1, 2, 1, 2},
                {2, 5, 3, 1},
                {-1, 3, 2, 4, 0, 1},
                {-1, 0}
                };
        sortAndPrintln(array1);
    }
    
    public static void sortAndPrintln(int[][] array1) {
        for (int n = 0; n < array1.length; n++) {
            quicksort(array1[n], 0, array1[n].length - 1);
            System.out.println(Arrays.toString(array1[n]));
        }
    }
  
    public static void quicksort(int[] array1, int startIndex, int endIndex) {
        int pivotValue = getPivot(array1, startIndex, endIndex);
        int currentStartIndex = startIndex;
        int currentEndIndex = endIndex;
        
        while (currentStartIndex < currentEndIndex) {
            while (array1[currentStartIndex] < pivotValue) {
                currentStartIndex++;
            } 
            while ((array1[currentEndIndex] > pivotValue) && (currentEndIndex > currentStartIndex)) {
                currentEndIndex--;
            }
            if (currentStartIndex < currentEndIndex) {
                swap(array1, currentStartIndex, currentEndIndex);
                if (currentEndIndex - currentStartIndex > 1) {
                    currentStartIndex++;
                    currentEndIndex--;
                } else {
                    break;
                }
            }
        }
        if ((currentStartIndex > startIndex)
                && (currentStartIndex - startIndex > 1))
            quicksort(array1, startIndex, currentStartIndex);
        if ((endIndex > currentEndIndex)
                && (endIndex - currentEndIndex > 1))
            quicksort(array1, currentEndIndex , endIndex);
    }
    
    
    private static void swap(int[] array1, int index1, int index2) {
        int buffer = array1[index1];
        array1[index1] = array1[index2];
        array1[index2] = buffer;
    }
  
  public static int getPivot(int[] array1, int startIndex, int endIndex) {
        return array1[endIndex - 1];
    }
}
