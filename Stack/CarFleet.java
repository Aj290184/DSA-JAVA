import java.util.*;

public class CarFleet {
    public static int carFleet(int target, int positions[], int speed[]){
        int n = positions.length;
        double cars[][] = new double[n][2];

        for(int i = 0; i < n; i++){
            cars[i][0] = positions[i];
            cars[i][1] = (double)(target - positions[i]) / speed[i];
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            Double time = cars[i][1];

            if(!stack.isEmpty() && time <= stack.peek()){
                continue;
            }

            stack.push(time);
        }

        return stack.size();
    }
    public static void main(String[] args) {
        int positions[] = {10,8,0,5,3}, speed[] = {2,4,1,1,3};
        System.out.println("Number of car fleets : " + carFleet(12, positions, speed));
    }
}