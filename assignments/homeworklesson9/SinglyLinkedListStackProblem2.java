package homeworklesson9;

// User Implementation of Stack
interface Stack1 {
    public void push(String ob);
    public String pop();
    public String peek();
    public boolean isEmpty();
    public int size();
}

// Node class for linked list
class Node {
    String value;
    Node next;
    Node(){
        this.next = null;
        this.value = null;
    }

    @Override
    public String toString() {
        return value == null ? "" : value;
    }
}

class SinglyLinkedListStack implements Stack1 {
    Node header;
    SinglyLinkedListStack(){
        header = new Node();
    }

    public void push(String item) { // add an item on top of stack
        if(item == null) return;
        Node n = new Node();
        n.value = item;
        if(!isEmpty())
                n.next = header.next;
        header.next = n;
    }

    public String pop() { // remove an item from top of stack
        if (isEmpty()) {
            return null;
        }
        Node item = header.next; // access top item
        header.next = item.next;
        return item.value;
    }

    public String peek() { // get top item of stack
        if (isEmpty())
            return null;
        return header.next.value;
    }

    public boolean isEmpty() { // true if stack is empty
        return header.next == null ? true : false;
    }

    public int size() { // returns number of items in the stack
        if(isEmpty()) return 0;
        Node loopNode = header;
        int counter = 0;
        while (loopNode.next != null){
            counter++;
            loopNode = loopNode.next;
        }
        return counter;
    }

    @Override
    public String toString(){ // returns the status of the status
        if(!isEmpty()){
            StringBuilder sb = new StringBuilder();
            Node loopNode = header;
            while (loopNode.next != null){
                sb.append(loopNode.next + " ");
                loopNode = loopNode.next;
            }
            return "[" + sb.toString() + "]";
        }
        return "[]";
    }

}

public class SinglyLinkedListStackProblem2 {
    public static void main(String[] args) {
        SinglyLinkedListStack stk = new SinglyLinkedListStack(); // create stack of size 4
        stk.push("John"); // push 4 items onto stack
        stk.push("Will");
        stk.push("Tom");
        stk.push("Melissa");

        System.out.println("Stack status after pushing 4 items : " + stk + " with size = " + stk.size());

        System.out.println("Popped Item = " + stk.pop());
        System.out.println("Stack status after popping one item " + stk + " with size = " + stk.size());

        stk.push("Thomas");
        stk.push("Michael");
        System.out.println("Stack status after pushing two items " + stk + " with size = " + stk.size());

        System.out.println("Peeked item = " + stk.peek());
        System.out.println("Stack status after peeking one item " + stk + " with size = " + stk.size());

    }

}
