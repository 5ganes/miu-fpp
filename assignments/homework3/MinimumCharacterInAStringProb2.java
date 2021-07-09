package homework3;

// to find minimum character in a string using recursive way.
public class MinimumCharacterInAStringProb2 {
    public static void main(String[] args){
        String string1 = "akel";
        try {
            System.out.println("Minimum Character in \"" + string1 + "\" is \'" + minCharacter(string1, string1.charAt(0)) + "\'");
        }
        catch (StringIndexOutOfBoundsException e){
            System.out.println("Please enter non empty string");
        }
    }

    // recursive function to find the minimum character in a string
    public static char minCharacter(String s, char minChar){
        if(s.isEmpty())
            return minChar;
        else{
            minChar = s.charAt(0) < minChar ? s.charAt(0) : minChar;
            // minChar = Character.compare(s.charAt(0), minChar) <= 0 ? s.charAt(0) : minChar; can also be used
            return minCharacter(s.substring(1), minChar);
        }
    }
}
