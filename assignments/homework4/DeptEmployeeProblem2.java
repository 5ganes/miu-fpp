package homework4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
    * general class to represent different employees in a department
 */
class DeptEmployee{
    private String name;
    protected double salary;
    private LocalDate hireDate;

    DeptEmployee(String name, double salary, LocalDate hireDate){
        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public double computeSalary(){
        return salary;
    }
}

/**
    * this class represents an employee of type Professor
 */
class Professor extends DeptEmployee{
    private int numberOfPublications;

    Professor(String name, double salary, LocalDate hireDate, int numberOfPublications){
        super(name, salary, hireDate);
        this.numberOfPublications = numberOfPublications;
    }

    public int getNumberOfPublications() {
        return numberOfPublications;
    }

    public void setNumberOfPublications(int numberOfPublications) {
        this.numberOfPublications = numberOfPublications;
    }
}

/**
    * this class represents an employee of type Secretary
 */
class Secretary extends DeptEmployee{
    private double overtimeHours;

    Secretary(String name, double salary, LocalDate hireDate, double overtimeHours){
        super(name, salary, hireDate);
        this.overtimeHours = overtimeHours;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double computeSalary(){
        return salary + 12 * overtimeHours;
    }
}

/**
 * main class to create different department employees and calculates total salary of all the employees
 */
public class DeptEmployeeProblem2 {
    public static void main(String[] args){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        Professor professor1 = new Professor("John Smith", 4000.0, LocalDate.parse("1980-12-15", formatter), 15);
        Professor professor2 = new Professor("Harry Butler", 4305.0, LocalDate.parse("1970-10-22", formatter), 22);
        Professor professor3 = new Professor("Fred Albert", 5450.5, LocalDate.parse("1960-08-06", formatter), 34);

        Secretary secretary1 = new Secretary("Fiyona Smith", 3900.6, LocalDate.parse("1977-09-06", formatter), 3);
        Secretary secretary2 = new Secretary("Amanda Butler", 4800.0, LocalDate.parse("1982-11-12", formatter), 2);

        DeptEmployee[] department = new DeptEmployee[5];

        department[0] = professor1;
        department[1] = professor2;
        department[2] = professor3;
        department[3] = secretary1;
        department[4] = secretary2;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter \"Y\" to see sum of the salaries of all the department employees :");
        String input = scanner.nextLine();
        switch (input){
            case "Y":
                double sumOfSalaries = 0.0;
                for (DeptEmployee employee : department){
                    sumOfSalaries += employee.computeSalary();
                }
                System.out.println("Sum of salaries of all the department employees = " + sumOfSalaries);
                break;
            default:
                break;
        }
    }
}
