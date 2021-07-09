package homeworklesson8list;

import java.util.Scanner;

class Person {
    private String lastName;
    private String firstName;
    private int age;

    public Person(String last, String first, int a) { // constructor
        lastName = last;
        firstName = first;
        age = a;
    }

    public String getLast() { // get last name
        return lastName;
    }

    @Override
    public String toString() {
        return "Person [lastName = " + lastName + ", FirstName = " + firstName + ", Age = " + age + "]";
    }
} // end class Person

class PersonList{
    private final int INITIAL_LENGTH = 4;
    private Person[] personArray;
    private int size;

    public PersonList() {
        personArray = new Person[INITIAL_LENGTH];
        size = 0;
    }
    // Add element in last
    public void add(Person p){
        if(p==null) return;
        if(size == personArray.length) resize();
        personArray[size++] = p;
    }

    public Person get(int i){
        if(i < 0 || i >= size){
            return null;
        }
        return personArray[i];
    }

    public Person find(String lastName){
        if(lastName == null) return null;
        for(Person person : personArray){
            //System.out.println(person.getLast());
            try {
                if(person.getLast().equals(lastName)) return person;
            }
            catch (NullPointerException e){
                return null;
            }
        }
        return null;
    }

    public void insert(Person p, int pos){
        if(pos > size || pos<0 ) return;
        if(pos == personArray.length||size+1 > personArray.length) {
            resize();
        }
        Person[] temp = new Person[personArray.length+1];
        System.arraycopy(personArray,0,temp,0,pos); // src, spos,des,dspos,number of elements
        temp[pos] = p;

        System.arraycopy(personArray,pos,temp,pos+1, personArray.length - pos);
        personArray = temp;
        ++size;
    }

    public boolean remove(Person p){
        if(size == 0) return false; // list is empty
        if(p==null) return false;
        int index = -1;
        for(int i = 0; i < size; ++i ){
            if(personArray[i].equals(p)){
                index = i;
                break;
            }
        }
        if(index==-1) return false; // s is not found in the list
        Person[] temp = new Person[personArray.length];
        System.arraycopy(personArray,0,temp,0,index);
        System.arraycopy(personArray,index+1,temp,index,personArray.length-(index+1));
        personArray = temp;
        --size;
        return true;
    }

    private void resize(){
        int len = personArray.length;
        int newlen = 2*len;
        Person[] temp = new Person[newlen];
        System.arraycopy(personArray,0,temp,0,len);
        // strArray = Arrays.copyOf(strArray, newlen);
        personArray = temp;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder("[\n");
        for(int i = 0; i < size-1; ++i){
            sb.append(personArray[i].toString()+", \n");
        }
        sb.append(personArray[size-1].toString()+" \n]\n");
        return sb.toString();
    }
    public int size() {
        return size;
    }
    public boolean isEmpty(){
        return(size==0);
    }

}


public class PersonListProblem1 {
    public static void main(String[] args) {
        PersonList pl = new PersonList();
        pl.add(new Person("Butler", "Thomas", 34));
        pl.add(new Person("Smith", "Steve", 30));
        pl.add(new Person("Susan", "Kyle", 54));
        Person p1 = new Person("Wood", "Mark", 22);
        pl.add(p1);

        Person p2 = new Person("Carry", "Alex", 29);
        pl.insert(p2, 2);
        System.out.println("After adding and inserting 5 persons : " + pl);

        pl.add(new Person("Wood", "Dave", 28));
        System.out.println("The list of size "+pl.size()+" is "+pl);

        pl.remove(p1);
        pl.remove(p2);
        System.out.println("After removing two persons : The list of size "+pl.size()+" is "+pl);

        pl.insert(new Person("Mike", "Richard", 66),3);
        System.out.println("The list of size "+pl.size()+" after inserting Richard into pos 3 is "+pl);
        pl.insert(new Person("Butler", "Tonya", 51),0);
        System.out.println("The list of size "+pl.size()+" after inserting Tonya into pos 0 is "+pl);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter last name of a person to search : ");
        String lastName = scanner.next();
        Person searchPerson = pl.find(lastName);
        scanner.close();
        if(searchPerson != null)
            System.out.println("Searching Result : " + searchPerson);
        else
            System.out.println("Person with " + lastName +  " is not found in the list");

        Exception e = new Exception("Woops");
        System.out.println(e.getMessage());


        try {
            int c = 5 + 6;
            throw new NoSuchMethodException("sdf");
        }
        catch(NoSuchMethodException nsme){
            System.out.println(nsme.getMessage());
            System.exit(0);
        }
    }
}
