import java.util.*;

class StockSpanner {
    Stack <int[]> stack;

    public StockSpanner() {    
        stack = new Stack<>();
    }

    public int next(int prices){
        int span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= prices) {
            span += stack.pop()[1];
        }

        stack.push(new int[] {prices, span});
        return span;
    }

    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();

        int prices[] = {80, 60, 70, 60, 75, 85};

        for (int price : prices) {
            int result = obj.next(price);
            System.out.println("Price : " + price + " → Span : " + result);
        }
    }
}