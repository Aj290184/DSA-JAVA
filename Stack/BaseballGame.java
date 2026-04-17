import java.util.*;

class BaseballGame {
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for(String op : ops){
            if(op.equals("+")){
                int last = stack.pop();
                int newScore = last + stack.peek();
                stack.push(last);
                stack.push(newScore);
            }
            else if(op.equals("D")){
                stack.push(2 * stack.peek());
            }
            else if(op.equals("C")){
                stack.pop();
            }
            else{
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int val : stack) {
            sum += val;
        }

        return sum;
    }
    public static void main(String[] args) {
     String ops[] = {"5","2","C","D","+"};
     System.out.println("Output : " + calPoints(ops));
    }
}