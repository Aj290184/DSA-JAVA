import java.util.*;

class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int result[] = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < temperatures.length; i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIdx = stack.pop();
                result[prevIdx] = i - prevIdx;
            }

            stack.push(i);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] temperatures = {30, 40, 35, 50, 25};
        int[] ans = dailyTemperatures(temperatures);
        System.out.println("Output: " + Arrays.toString(ans));
    }
}