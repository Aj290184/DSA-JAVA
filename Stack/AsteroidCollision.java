import java.util.*;

public class AsteroidCollision {
    public static int[] asteroidCollision(int asteroids[]){
        Stack<Integer> stack = new Stack<>();

        for (int aster : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty() && stack.peek() > 0 && aster < 0) {
                if(Math.abs(stack.peek()) < Math.abs(aster)){
                    stack.pop();
                    continue;
                }
                else if(Math.abs(stack.peek()) == Math.abs(aster)){
                    stack.pop();
                    continue;
                }

                destroyed = true;
                break;
            }
            
            if(!destroyed){
                stack.push(aster);
            }
        }

        int result[] = new int[stack.size()];
        for(int i = result.length - 1; i >= 0; i--){
            result[i] = stack.pop();
        }

        return result;
    }
    public static void main(String[] args) {
        int asteroids[] = {5,10,-5};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }
}