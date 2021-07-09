package Homework1;

public class Prog1{
        public static void main(String[] args){

                int x = RandomNumbers.getRandomInt(1, 9); // get a random number between 1 - 9
                System.out.println(x + " to the power PI =" + Math.pow((Math.PI), x)); // calculate result

                int y = RandomNumbers.getRandomInt(3, 14); // get a random number between 3 - 14
                System.out.println("PI to the power " + y + " = " + Math.pow(y, (Math.PI))); // calculate result

                // this can also be done by creating an instance of class RandomNumbers
                /**
                        RandomNumbers r = new RandomNumbers(); // but constructor of the class should be public
                        int x = r.getRandomInt(1, 9);
                */

        }
}