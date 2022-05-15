import java.util.*;
import java.lang.*;

class Rextester
{  
    
    public static void main(String args[]) {
        int[] arr = { 3,6,1,0,2,8,10,4,9,5,7,89,4,56,78,9,32,45,76,87,15,68,92,83,81,123,84}; 
        bubbleSort(arr);
        for (int h = 0; h < arr.length; h++)
            System.out.print(arr[h] + " ");
    }
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
     public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > value) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = value;
        }
    }
     
    public static void ShellSort(int[] arr) {
        int increment = arr.length / 2;
        while (increment > 0) {
            for (int i = increment; i < arr.length; i++) {
                int j = i;
                int temp = arr[i];
                while (j >= increment && arr[j - increment] > temp) {
                    arr[j] = arr[j - increment];
                    j = j - increment;
                }
                arr[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }
    }
    public static void BucketSort(int[]arr)
    {     int j2,j3;
        int max = arr[0];
        int min = arr[0];
        for(int i = 0; i < arr.length ; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
            if(arr[i] < min)
            {
                min = arr[i];
            }   
        }
    
        int[] bucket1 = new int[arr.length]; 
        for (int i = 0; i < arr.length; i++) 
        bucket1[i] = 88; 
    
        int[] bucket2 = new int[arr.length]; 
        for (int i = 0; i < arr.length; i++) 
        bucket2[i] = 88; 

    
        int range = ((max - min)/2) + 1;
       
        int j = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if((arr[i] >= min) && (arr[i] < min + range))
            {
                bucket1[j] = arr[i];
                j ++;
            }
        }
       
        j2 = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if((arr[i] >= min + range) && (arr[i] <= max))
            {
                bucket2[j2] = arr[i];
                j2 ++;
            }
        }
       
       
        insertionSort(bucket1);
       
      ShellSort(bucket2);
        
  
    j =0;
     j2=0;
    
for (int i=0; i< arr.length; i++)
{ 
if(bucket1[j]<88){
    arr[i]=bucket1[j]; 
j++;} 
else{if(bucket2[j2]<88){ 
arr[i]=bucket2[j2]; 
j2++;} 


    }}
}
}
