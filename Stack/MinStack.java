import java.util.Stack;

class MinStack {
    private Stack <Integer> inStack;
    private Stack <Integer> minStack;

    public MinStack(){
        inStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val){
        inStack.push(val);

        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop(){
        if(minStack.peek().equals(inStack.peek())){
            minStack.pop();
        }

        inStack.pop();
    }

    public int top(){
        return inStack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(3);
        obj.push(1);
        obj.push(2);
        System.out.println("Min value : " + obj.getMin());
    }
}