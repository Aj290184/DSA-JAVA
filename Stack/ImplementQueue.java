import java.util.*;

class ImplementQueue {
    private Stack <Integer> inStack;
    private Stack <Integer> outStack;

    public ImplementQueue(){
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x){
        inStack.push(x);
    }

    public int pop(){
        moveIfNeeded();
        return outStack.pop();
    }

    public int peek(){
        moveIfNeeded();
        return outStack.peek();
    }

    public boolean isEmpty(){
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public void moveIfNeeded(){
        if(outStack.isEmpty()){
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        ImplementQueue q = new ImplementQueue(); 

        q.push(1);
        q.push(2);
        q.push(3);

        System.out.println(q.pop());
        System.out.println(q.peek());
        System.out.println(q.isEmpty());
    }
}