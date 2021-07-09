package homework12exceptionhandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        System.out.println("Enter a number from 1 t0 100 : ");
        Scanner scanner = new Scanner(System.in);
        try {
            int i = scanner.nextInt();
            if(i < 0 || i > 100)
                throw new UnsupportedOperationException("Please enter an integer of the range 0 - 100");
        }
        catch (InputMismatchException e){
            System.out.println("You can not enter value other than integers");
        }
        catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }
    }
}
