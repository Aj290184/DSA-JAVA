import java.util.*;

public class EvaluateRPN {
    public static int evalRPN(String tokens[]){
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if(token.equals("+") || token.equals("-")
            || token.equals("*") || token.equals("/")){

            int b = stack.poll();
            int a = stack.poll();

            int result = 0;

            switch (token) {
                case "+" :
                result = a + b;
                break;

                case "-" :
                result = a - b;
                break;

                case "*" :
                result = a * b;
                break;

                case "/" :
                result = a / b;
                break;
            }

            stack.push(result);
        }
        else{
            stack.push(Integer.parseInt(token));
        }
    }

    return stack.pop();
}
    public static void main(String[] args) {
        String tokens[] = {"2","1","+","3","*"};
        System.out.println("Output : " + evalRPN(tokens));
    }
}