package homeworklesson9;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class ArrayQueueImpl {
    private int[] arr = new int[10];
    private int front = -1;
    private int rear = 0;

    public int peek() {
        if(front != -1)
            return arr[0];
        else
            return front;
    }
    public void enqueue(int obj){
        if(rear == arr.length){
            resize();
        }
        arr[rear++] = obj;
        front++;
    }
    public int dequeue() {
        if(front >= 0){
            int retEl = arr[0];
            int[] arrTmp = new int[arr.length - 1];
            System.arraycopy(arr, 1, arrTmp, 0, arr.length - 1);
            arr = arrTmp;
            rear--;
            front--;
            return retEl;
        }
        else
            return front;
    }
    public boolean isEmpty(){
        if(front < 0)
            return true;
        else
            return false;
    }
    public int size(){
        return rear;
    }
    private void resize(){
        int[] arrTmp = new int[arr.length * 2];
        System.arraycopy(arr,0, arrTmp,0, arr.length);
        arr = arrTmp;
    }
    @Override
    public String toString(){
        return Arrays.toString(arr);
    }
}

public class ArrayQueueProblem1 {
    public static void main(String[] args) {
        ArrayQueueImpl q1 = new ArrayQueueImpl();
        q1.enqueue(1); q1.enqueue(2); q1.enqueue(3); q1.enqueue(4);
        q1.enqueue(5); q1.enqueue(6); q1.enqueue(7); q1.enqueue(8);
        q1.enqueue(9); q1.enqueue(10); q1.enqueue(11);

        System.out.println("Queue after adding 11 numbers : " + q1 + " with size = " + q1.size());

        int dq = q1.dequeue(); // remove element
        if(q1.dequeue() == -1) System.out.println("Queue is empty");

        dq = q1.dequeue(); dq = q1.dequeue(); dq = q1.dequeue(); dq = q1.dequeue();
        System.out.println(q1); // dequeue some elements
        System.out.println("Queue after dequeue of 6 times : " + q1 + " with size = " + q1.size());

        System.out.println("Is queue empty : " + q1.isEmpty());
        dq = q1.dequeue();dq = q1.dequeue(); dq = q1.dequeue(); dq = q1.dequeue(); dq = q1.dequeue();
        System.out.println("Queue after dequeue 5 times : " + q1 + " with size = " + q1.size());

        if(q1.dequeue() == -1) System.out.println("Queue is empty : was trying to dequeue");
        if(q1.peek() == -1) System.out.println("Queue is empty : was trying to peek");

        q1.enqueue(9); q1.enqueue(10);
        System.out.println("Queue after enqueue of 2 elements : " + q1 + " with size = " + q1.size());

        System.out.println("peeked element at this time : " + q1.peek());

        Queue<Integer> q = new LinkedList<>();
        q.add(6);
        q.add(7);
        q.add(8);
        System.out.println(q.remove()); // q.poll() can also be used

        Stack<Integer> s = new Stack<>();
        s.push(6);
        s.push(7);
        s.push(8);
        System.out.println(s.pop());

    }
}
