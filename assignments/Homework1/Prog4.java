package Homework1;

/**
    This class is used to display lengths of command line string arguments and arguments starting with A.
*/
public class Prog4 {
    public static void main(String[] args) {
        if(args == null || args.length == 0) { // runs if no arguments are supplied
            System.out.println("No command line arguments supplied");
        }
        else {
            int inputsStartingWithACount = 0; // counter for string inputs starting with 'A'
            for(String el : args) { // loop over arguments supplied
                System.out.println("Length of " + el + " = " + el.length()); // display length of each string input
                if(el.charAt(0) == 'A') // increase counter if an input string starts with 'A'
                    inputsStartingWithACount++;
            }

            // display counter
            System.out.println("Number of Input Strings starting with A = " + inputsStartingWithACount);
        }
    }

}
