class RotateFunction {
    public static int maxRotateFunction(int[] nums) {
        int n = nums.length;

        int sum = 0;
        int f0 = 0;

        for(int i = 0; i < n; i++){
            sum += nums[i];
            f0 += i * nums[i];
        }

        int curr = f0;
        int max = f0;

        for(int k = 1; k < n; k++){
            curr = curr + sum - n * nums[n - k];
            max = Math.max(max, curr);
        }

        return max;
    }
    public static void main(String[] args) {
     int nums[] = {4,3,2,6};
     System.out.println("Output : " + maxRotateFunction(nums));
    }
}