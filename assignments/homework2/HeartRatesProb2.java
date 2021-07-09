package homework2;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
    * this class has three private properties namely "firstName", "lastName", "dateOfBirth".
    * It has a constructor to initialize the values of all the properties
    * It has getters(accessors) and setters(mutators) for all the properties of the class.
*/
class HeartRates{
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    final int rhr = 70;
    final double lb = 0.5d;
    final double ub = 0.85d;

    HeartRates(String firstName, String lastName, LocalDate dateOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge(){ // calculates age(in years) of a person
        LocalDate today = LocalDate.now();
        return Math.abs(Period.between(today, dateOfBirth).getYears());
    }

    public int getMaxHeartRate(){
        return 220 - getAge();
    } // calculates maximum heart rate of a person

    public void showTargetHeartRateRange(){ // calculates and displays target heart rate range of a person
        int ahr = getMaxHeartRate() - rhr; // auto type casting from int to double
        double lbthr = (ahr * lb) + rhr;
        double ubthr = (ahr * ub) + rhr;
        System.out.println("The Target Heart Rate Range is between " + lbthr + " and " + ubthr);
    }

    @Override
    public String toString(){ // overrides default toString method of an object.
        return  "First Name : " + firstName +
                "\nLast Name : " + lastName +
                "\nAge : " + getAge() +
                "\nDate of Birth : " + dateOfBirth +
                "\nMaximum Heart Rate : " + getMaxHeartRate();
    }

}

/**
    * tests and calculates the different heart rates of a person
*/

public class HeartRatesProb2 {

    public static void main(String[] args){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your first name : ");
        String firstName = scanner.nextLine();

        System.out.println("Please enter your last name : ");
        String lastName = scanner.nextLine();

        System.out.println("Please enter your birthday in yyyy-MM-dd format (e.g. 1980-9-28) : ");
        String inputDate = scanner.nextLine();
        scanner.close();
        LocalDate dateOfBirth;
        try {
            dateOfBirth = LocalDate.parse(inputDate, formatter);
            HeartRates person = new HeartRates(firstName, lastName, dateOfBirth);

            person.showTargetHeartRateRange();
            System.out.println(person.toString());
        } catch(DateTimeParseException e) {
            System.out.println("Error! Please enter valid date again");
        }

    }

}