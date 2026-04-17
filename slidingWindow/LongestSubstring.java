import java.util.*;
class LongestSubstring {
    public static int lengthOfLongestSubstring(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(map.containsKey(ch)){
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, i);
            maxLength = Math.max(maxLength, i - left + 1);
        }

        return maxLength;
    }
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println("Output : " + lengthOfLongestSubstring(str));
    }
}