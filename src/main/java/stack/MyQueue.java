package stack;

import java.util.Stack;

//using stack to implement queue
public class MyQueue {

    private final Stack<Integer> stackA;
    private final Stack<Integer> stackB;

    /** Initialize your data structure here. */
    public MyQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackA.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stackB.isEmpty()) {
            transfer(stackB, stackA);
        }
        return stackB.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stackB.isEmpty()) {
           transfer(stackB, stackA);
        }
        return stackB.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }

    private void transfer(Stack<Integer> in, Stack<Integer> out) {
        while (!out.isEmpty()) {
            in.push(out.pop());
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        System.out.println(myQueue.empty());
        myQueue.push(1);
        System.out.println(myQueue.peek() == 1);
        System.out.println(myQueue.pop() == 1);
        System.out.println(myQueue.empty());
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);

        System.out.println(myQueue.peek()==1);
        System.out.println(myQueue.pop() == 1);
        System.out.println(myQueue.pop() == 2);
        myQueue.push(4);
        System.out.println(myQueue.pop() == 3);
        System.out.println(myQueue.peek() == 4);
        System.out.println(myQueue.pop() == 4);
        System.out.println(myQueue.empty());

    }
}
