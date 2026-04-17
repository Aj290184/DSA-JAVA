import java.util.*;

class ImplementStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public ImplementStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x){
        q2.offer(x);

        while (!q1.isEmpty()) {
            q2.offer(q1.remove());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop(){
        return q1.remove();
    }

    public int top(){
        return q1.peek();
    }

    public boolean isEmpty(){
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStack stack = new ImplementStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top : " + stack.top());
        System.out.println("Pop : " + stack.pop());
        System.out.println("Top : " + stack.top());
        System.out.println("Is Empty: " + stack.isEmpty());
    }
}