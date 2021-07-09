package homework3;

import java.util.Arrays;

// implementation of binary search on an array of strings
public class RecursiveBinarySearchProb3 {
    public static void main(String[] args){
        String[] arr = new String[] { "john", "fiyona", "albert", "haward", "melissa", "dabby", "ford"};
        Arrays.sort(arr);
        String el = "haward";
        System.out.println(binarySearch(arr, el, 0, arr.length-1));
    }

    // function definition
    public static String binarySearch(String[] arr, String el, int start, int end){
        if(end < start) // element not found if this condition is true
            return "-1";
        else{
            int middleIndex = start + (end-start)/2; // calculate the middle index of array
            if(arr[middleIndex].equals(el)) // return element if found on middle index
                return el;
            else if(el.compareTo(arr[middleIndex]) < 0){ // recursive call on first half of the array
                return binarySearch(arr, el, start, middleIndex-1);
            }
            else // recursive call on second half of the array
                return binarySearch(arr, el, middleIndex+1, end);
        }
    }
}
