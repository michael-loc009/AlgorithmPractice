/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author locdi
 */
public class SelectionSortTest {

    public static void SelectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            //Store the current unsorted element
            int min_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    //Save the index of the smallest element in the unsorted zone
                    min_index = j;
                }

            }
            //Swap the smaller element to the left 
            int smallerNo = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = smallerNo;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void BubbleSort(int[] arr) {
        boolean swap;
        do {
            //Stop the loop when swap is false
            swap = false;
            //Loop run from the 1st element to the n-1th element
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    //Continue to loop if swap is needed
                    swap = true;
                }
            }
        } while (swap == true);

        System.out.println(Arrays.toString(arr));
    }

    static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        //Index for left
        int i = 0;
        //Index for right
        int j = 0;
        //Index for result
        int index = 0;

        //Sort and Combine two half into one
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[index++] = left[i++];
            } else {
                result[index++] = right[j++];
            }
        }

        //only one of these loops will be executed
        //Combine each group of left half into one 
        while (i < left.length) {
            result[index++] = left[i++];
        }

        //Combine each group of right half into one
        while (j < right.length) {
            result[index++] = right[j++];
        }

        return result;
    }

    public static int[] MergeSort(int[] arr) {
        int[] left;
        int[] right;

        //Initialize the size for each pair
        if (arr.length % 2 == 0) {
            left = new int[arr.length / 2];
            right = new int[arr.length / 2];
        } else {
            left = new int[arr.length / 2];
            right = new int[arr.length / 2 + 1];
        }

        //Add value to left and right pair
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length / 2) {
                left[i] = arr[i];
            } else {
                right[i - arr.length / 2] = arr[i];
            }
        }

        //Stop recursion when cannot slit array into groups of 2
        if (left.length >= 2) {
            left = MergeSort(left);
        }
        if (right.length >= 2) {
            right = MergeSort(right);
        }
        //Start merge with the first pair of left
        return merge(left, right);
    }

    public void InsertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are 
             greater than key, to one position ahead 
             of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            //return the key to the last position of sorted part
            arr[j + 1] = key;
        }
    }

    static int BinarySearch(int[] lst, int searchNo, int l, int r) {

//        int mid = l + (r - l) / 2;
//
//        //Keep search until l > r
//        if (r >= l) {
//            //Search until find a lst[mid] = searchNo
//            if (lst[mid] == searchNo) {
//                return mid;
//            }
//
//            if (lst[mid] < searchNo) {
//                return BinarySearch(lst, searchNo, mid + 1, r);
//
//            } else {
//                return BinarySearch(lst, searchNo, l, mid - 1);
//            }
//        }
        while (r >= l) {
            int mid = l + (r - l) / 2;
            if (lst[mid] == searchNo) {
                return mid;
            }
            if (lst[mid] < searchNo) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /* This function takes last element as pivot, 
     places the pivot element at its correct 
     position in sorted array, and places all 
     smaller (smaller than pivot) to left of 
     pivot and all greater elements to right 
     of pivot */
    static int Partition(int arr[], int low, int high) {

        //i for green zone greater than pivot
        //j for red zone smaller than pivot
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element 
        for (int j = low; j < high; j++) {
            // If current element is smaller than or 
            // equal to pivot 
            if (arr[j] <= pivot) {

                i++;

                // swap arr[i] and arr[j] 
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot) 
        //arr[i+1] 1st ele of green zone
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        //return the 2nd ele of green zone
        return i + 1;
    }

    static int[] Quicksort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is  
             now at right place */
            int pi = Partition(arr, low, high);

            // Recursively sort elements before 
            // partition and after partition 
            Quicksort(arr, low, pi - 1);
            Quicksort(arr, pi + 1, high);
        }
        return arr;
    }

    static int changeCoinGreedy(int amount, int[] coinList) {
        int coinNo = 0;

        for (int i = coinList.length - 1; i >= 0; i--) {
            while (amount >= coinList[i]) {
                amount = amount - coinList[i];
                coinNo = coinNo + 1;
            }
        }

//        for (int i : coinList) {
//            while (amount <= i) {
//                amount -= i;
//                coinNo += 1;
//            }
//        }
        return coinNo;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int[] result = MergeSort(arr);
        System.out.println(Arrays.toString(result));

        System.out.println(changeCoinGreedy(20, result));

//        int x = 10;
//        int n = arr.length;
//        int res = BinarySearch(result, x, 0, n - 1);
//        if (res == -1) {
//            System.out.println("Not found");
//        } else {
//            System.out.printf("%d is found in the list at index %d", x, res);
//        }
    }

}
