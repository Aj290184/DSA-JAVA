class SplitLargestSum {

    public static int splitArray(int nums[], int k){
        int left = 0, right = 0;

        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if(canSlipt(nums, k, mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }

    public static boolean canSlipt(int nums[], int k, int maxSum){
        int count = 1;
        int currSum = 0;

        for (int num : nums) {
            if(num + currSum > maxSum){
                count++;
                currSum = num;
            }else{
                currSum += num;
            }
        }

        return count <= k;
    }
    public static void main(String[] args) {
        int nums[] = {7,2,5,10,8}, k = 2;
        System.out.println("Largest Sum : " + splitArray(nums, k));
    }
}