package Homework1;

import java.util.Arrays;

public class Prog5 {
    public static void main(String[] args){
        int[] a = new int[] { 5, 6, -4, 3, 1 };
        int[] b = new int[] { 3, 8, 9, 11 };
        int[] combinedArray = combine(a, b);
        System.out.println("Combined Array : " + Arrays.toString(combinedArray)); // display combined array
    }

    /**
        this function takes two int arrays and returns an array after combing these two arrays
    */
    public static int[] combine(int[] a, int[] b){
        if(a.length == 0 && b.length == 0)
            return new int[0];
        else if(a.length == 0)
            return b;
        else if(b.length == 0)
            return a;
        else {
            int[] combinedArray = new int[a.length + b.length];
            System.arraycopy(a, 0, combinedArray, 0, a.length);
            System.arraycopy(b, 0, combinedArray, a.length, b.length);

            return combinedArray;
        }
    }
}
