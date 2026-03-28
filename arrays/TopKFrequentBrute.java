import java.util.*;
class TopKFrequentBrute {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int i = 0; i < k; i++){
            int maxFreq = 0;
            int element = -1;

            for(int key : map.keySet()){
                if(map.get(key) > maxFreq){
                    maxFreq = map.get(key);
                    element = key;
                }
            }

            ans.add(element);
            map.remove(element);
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(topKFrequent(nums, k));
    }
}