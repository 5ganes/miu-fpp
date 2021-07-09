package homework4;

/**
 * abstract class
 * base class for all the types of employees
 * abstract method getPayment()
 */
abstract class Employee{
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    public void setSocialSecurityNumber(String socialSecurityNumber){
        this.socialSecurityNumber = socialSecurityNumber;
    }

    Employee(String firstName, String lastName, String socialSecurityNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber =socialSecurityNumber;
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

    public String getSocialSecurityNumber(){
        return socialSecurityNumber;
    }

    public String toString(){
        return firstName + " " + lastName + " has SSN " + socialSecurityNumber;
    }

    public abstract double getPayment();
}

/**
 * Commission Employee class
 * extends Employee class to override getPayment method
 */
class CommissionEmployee extends Employee{
    private double grossSales;
    private double commissionRate;

    CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate){
        super(firstName, lastName, socialSecurityNumber);
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    public double getGrossSales(){
        return grossSales;
    }

    public void setGrossSales(double grossSales){
        this.grossSales = grossSales;
    }

    public double getCommissionRate(){
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate){
        this.commissionRate = commissionRate;
    }

    @Override
    public double getPayment(){
        return grossSales * commissionRate;
    }

    @Override
    public String toString(){
        return super.toString() + " with Salary " + getPayment();
    }
}
/**
 * Base plus Commission Employee class
 * extends Commission Employee class and overrides getPayment method
 */
class BasePlusCommissionEmployee extends CommissionEmployee{
    private double baseSalary;

    BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary){
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary(){
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary){
        this.baseSalary = baseSalary;
    }

    @Override
    public double getPayment(){
        return baseSalary + (getGrossSales() * getCommissionRate());
    }
}

/**
 * Hourly Employee class
 * extends Employee class to override getPayment method
 */
class HourlyEmployee extends Employee{
    private double wage;
    private double hours;

    HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours){
        super(firstName, lastName, socialSecurityNumber);
        this.wage = wage;
        this.hours = hours;
    }

    public double getWage(){
        return wage;
    }

    public void setWage(double wage){
        this.wage = wage;
    }

    public double getHours(){
        return hours;
    }

    public void setHours(double hours){
        this.hours = hours;
    }

    @Override
    public double getPayment(){
        return wage * hours;
    }

    @Override
    public String toString(){
        return super.toString() + " with Salary " + getPayment();
    }
}

/**
 * SalariedEmployee class
 * extends Employee class to override getPayment method
 */
class SalariedEmployee extends Employee{
    private double weeklySalary;

    SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary){
        super(firstName, lastName, socialSecurityNumber);
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary(){
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary){
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double getPayment(){
        return weeklySalary;
    }

    @Override
    public String toString(){
        return super.toString() + " with Salary " + getPayment();
    }
}

/**
 * main class to test and display total salary of all the employees
 */
public class EmployeeProblem4 {
    public static void main(String[] args){

        // objects instantiation of different employees and store them in an array of type Employee
        Employee[] employeeArray = new Employee[5];
        employeeArray[0] = new CommissionEmployee("John", "Smith", "S1235", 2341.0, 20.0);
        employeeArray[1] = new CommissionEmployee("Harry", "Butler", "S43524", 78641.6, 15.0);
        employeeArray[2] = new BasePlusCommissionEmployee("Fred", "Albert", "S80542", 45445.4, 12.0, 3000.0);
        employeeArray[3] = new HourlyEmployee("Fiyona", "Butler", "S90111", 2555.0, 9.0);
        employeeArray[4] = new SalariedEmployee("Amanda", "Smith", "S11134", 120.0);

        double totalSalary = 0.0;
        for (Employee employee : employeeArray){ // compute total salary
            // display status of an object
            System.out.println("(" + employee.getClass().getSimpleName() + ")" + employee.toString());
            totalSalary += employee.getPayment();
        }
        System.out.println();
        System.out.println("Total salary of all the employees = " + totalSalary); // display total salary of all the employees
    }
}
