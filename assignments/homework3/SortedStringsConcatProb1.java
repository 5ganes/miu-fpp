package homework3;

// to find out a sorted string after joining two sorted strings
public class SortedStringsConcatProb1 {
    public static void main(String[] args){
        String string1 = "ace";
        String string2 = "bdf";
        String combinedString = stringConcat(string1, string2);
        System.out.println("Sorted String is " + combinedString); // display resultant sorted string
    }

    // function definition (auto type casting happens from char to String)
    public static String stringConcat(String s1, String s2){
        if(s1.length() == 0) return s2;
        else if(s2.length() == 0) return s1;
        else{
            if(s1.charAt(0) <= s2.charAt(0)) // if(Character.compare(s1.charAt(0), s2.charAt(0)) <= 0) can also be used
                return s1.charAt(0) + stringConcat(s1.substring(1), s2);
            else
                return s2.charAt(0) + stringConcat(s1, s2.substring(1));
        }

    }
}
