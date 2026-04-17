class MinimumSizeSubarray {
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            while (sum >= target) {
                minLen = Math.min(minLen, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        
        return minLen;
    }
    public static void main(String[] args) {
     int nums[] = {2,3,1,2,4,3};
     System.out.println("Output : " + minSubArrayLen(7, nums));
    }
}