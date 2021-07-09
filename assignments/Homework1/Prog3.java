package Homework1;

import java.util.Arrays;

public class Prog3 {

    public static void main(String[] args){
        String[] animals = new String[] {"horse", "dog", "cat", "horse", "dog"}; // array initialization
        String[] uniqueList = removeDups(animals); // removeDups method call

        //  display the resultant unique array
        System.out.println("Array after removing duplicates : " + Arrays.toString(uniqueList));
    }

    /**
        this function takes a String array and returns a new array
        with no duplicates elements of original array
    */
    public static String[] removeDups(String[] animals){ // removeDups method definitation
        if(animals.length ==0 || animals.length == 1)
            return animals;
        int duplicatesCount = 0;
        for(int i = 0; i < animals.length-1; i++) { // calculates number of duplicates in the array
            for (int j = i + 1; j < animals.length; j++) {
                if (animals[i].equals(animals[j])) {
                    duplicatesCount++;
                    break;
                }
            }
        }
        int uniqueArraySize = animals.length - duplicatesCount; // calculates size of new array
        String[] uniqueList = new String[uniqueArraySize]; // new array declaration
        int uniqueListIndex = 0; // new array index
        for (String el : animals){
            if(!doesContain(uniqueList, el)){ // checks whether an element is already present in new array or not
                uniqueList[uniqueListIndex++] = el; // if not present, insert element into new array
            }
        }
        return uniqueList; //  return new array
    }

    // method to check whether an element is present in an array or not
    public static boolean doesContain(String[] array, String element){
        for (String el : array){
            if(element.equals(el))
                return true;
        }
        return false;
    }

}
