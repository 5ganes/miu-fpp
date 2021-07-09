package homework2;

/**
    * this class has five private properties namely "firstName", "lastName"
    * "socSecurityNum", "billingAddress", "shippingAddress".
    * It has a constructor to initialize the values of all the properties
    * It has getters(accessors) and setters(mutators) for all the properties of the class.
    * It has one method called toString which overrides default toString method of an object.
*/
class Customer {
    private String firstName;
    private String lastName;
    private String socSecurityNum;
    private Address billingAddress;
    private Address shippingAddress;

    Customer(String firstName, String lastName, String socSecurityNum){
        this.firstName = firstName;
        this.lastName = lastName;
        this.socSecurityNum = socSecurityNum;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setSocSecurityNum(String socSecurityNum){
        this.socSecurityNum = socSecurityNum;
    }

    public String getSocSecurityNum(){
        return socSecurityNum;
    }

    public void setBillingAddress(Address billingAddress){
        this.billingAddress = billingAddress;
    }

    public Address getBillingAddress(){
        return billingAddress;
    }

    public void setShippingAddress(Address shippingAddress){
        this.shippingAddress = shippingAddress;
    }

    public Address getShippingAddress(){
        return shippingAddress;
    }

    @Override
    public String toString() {
        return "[" + firstName + ", " + lastName + ", " + "ssn: " + socSecurityNum + "]";
    }

}

/**
    * this class has four private properties namely "street", "city", "state", "zip"
    * It has a constructor to initialize the values of all the properties
    * It has one getter for a property "city"
 */
class Address {
    private String street;
    private String city;
    private String state;
    private String zip;

    Address(String street, String city, String state, String zip){
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getCity(){
        return city;
    }

}

/**
     * This class is used for testing Customer and Address classes
 */
public class Problem1 {
    public static void main(String[] args){
        Customer[] customerArr = new Customer[3]; // define an array of Customer objects
        int customerArrIndex = 0;

        // first Customer object instantiation
        Customer c = new Customer("John", "Hank", "A1234");
        c.setBillingAddress(new Address("4th Street", "Fairfield", "Iowa", "52557"));
        c.setShippingAddress(new Address("12th Street", "Colorado City", "Colorado", "12345"));
        customerArr[customerArrIndex++] = c; // store object into customer array

        // second Customer object instantiation
        c = new Customer("Tomas", "Butler", "B1234");
        c.setBillingAddress(new Address("10th Street", "Chicago", "Illinois", "34255"));
        c.setShippingAddress(new Address("11th Street", "Fairfield", "Iowa", "52557"));
        customerArr[customerArrIndex++] = c; // store object into customer array

        // third Customer object instantiation
        c = new Customer("Fiyona", "Smith", "C1234");
        c.setBillingAddress(new Address("2nd Street", "Chicago", "Illinois", "34255"));
        c.setShippingAddress(new Address("5nd Street", "Colorado City", "Colorado", "54321"));
        customerArr[customerArrIndex] = c; // store object into customer array

        // loop through the Customer array and display those customers whose billing address city is in Chicago
        for (Customer customer : customerArr){
            if(customer.getBillingAddress().getCity().equals("Chicago")){
                System.out.println(customer.toString());
            }
        }

    }
}