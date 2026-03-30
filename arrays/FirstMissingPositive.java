import java.util.*;

class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        
        int i = 1;
        while (true) {
            if (!set.contains(i)) {
                return i;
            }
            i++;
        }
    }
    public static void main(String[] args) {
     int nums[] = {1,2,0};
     System.out.println(firstMissingPositive(nums));
    }
}