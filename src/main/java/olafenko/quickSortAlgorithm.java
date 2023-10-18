package olafenko;

import java.util.Arrays;
import java.util.Random;

public class quickSortAlgorithm {

    private  int[] numbers = new int[10];

    private final int len = numbers.length;

    public void run(){

        arrRandomize(numbers);

        System.out.println("Before: ");
        System.out.println(Arrays.toString(numbers));
        quickSort(numbers);
        System.out.println("After: ");
        System.out.println(Arrays.toString(numbers));


    }


    private void quickSort(int[] arr){
        quickSort(arr, 0,len - 1);
    }


    private void quickSort(int[] arr, int lowIndex, int highIndex){




        if(lowIndex >= highIndex){
            return;
        }

        int pivot = arr[highIndex];

        int leftPointer = partition(arr, lowIndex, highIndex, pivot);

        quickSort(arr, lowIndex,leftPointer - 1 );
        quickSort(arr, leftPointer + 1, highIndex);


    }

    private int partition(int[] arr, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;


        while (leftPointer < rightPointer) {

            while (arr[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (arr[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(arr, leftPointer, rightPointer);

        }

        swap(arr,leftPointer, highIndex);
        return leftPointer;
    }


    private void arrRandomize(int[] arr){

        Random random = new Random();

        for(int i =0;i<len; i++){
            numbers[i] = random.nextInt(100);
        }

    }

    private void swap(int[]arr, int index1, int index2) {

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

    }







}
