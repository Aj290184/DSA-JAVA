class ContainsDupBrute {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

     for(int i = 0; i < nums.length; i++){
      for(int j = 0; j < i; j++){
       if(nums[i] == nums[j] && i - j <= k){
        return true;
       }
      }
     }
     return false;
    }
    public static void main(String[] args) {
     int nums[] = {1,2,3,1};
     System.out.println(containsNearbyDuplicate(nums, 3));
    }
}