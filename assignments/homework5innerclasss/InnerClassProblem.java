package homework5innerclasss;

class MyTable{
    private Entry[] entries = new Entry[26];

    //returns the String that is matched with char c in the table
    public String get(char c){
        if(entries[(int)c - 97] != null) // "if(entries[(int)c - 97] instanceof Entry)" can also be used
            return entries[(int)c - 97].str;
        return null;
    }
    //adds to the table a pair (c, s) so that s can be looked up using c
    public void add(char c, String s) {
        if(entries[(int)c - 97] != null)
            entries[(int)c - 97].str = s;
        else
            entries[(int)c - 97] = new Entry(c, s);
    }
    //returns a String consisting of nicely formatted display
    //of the contents of the table
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        for(Entry e : entries){
            // if entries index contains only object of Entry class
            if(e != null) // "e instanceof Entry" can also be used
                resultString.append(e.toString() + "\n");
        }
        return resultString.toString();
    }

    private class Entry {
        char ch;
        String str;
        Entry(char ch, String str){
            this.ch = ch;
            this.str = str;
        }
        //returns a String of the form "ch->str"
        public String toString() {
            return this.ch + " -> " + this.str;
        }
    }
}

public class InnerClassProblem {
    public static void main(String[] args){
        MyTable t = new MyTable();
        t.add('a', "Andrew");
        t.add('b',"Billy");
        t.add('d',"Charlie");
        t.add('b', "Ram");
        String s = t.get('b');
        System.out.println(t.get('b'));
        System.out.println(t);
    }
}
