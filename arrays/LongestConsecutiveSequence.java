import java.util.*;

class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for(int num : set){
            if(!set.contains(num - 1)){
                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }
                longest = Math.max(count, longest);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int nums[] = {2,20,4,10,3,4,5};
        System.out.println("Longest consecutive elements sequence length is : " + longestConsecutive(nums));
    }
}