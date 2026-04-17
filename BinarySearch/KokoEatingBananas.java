class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 0;
        int high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long totalHours = 0;

            for (int pile : piles) {
                totalHours += (pile + mid - 1) / mid;
            }

            if(totalHours <= h){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
     int piles[] = {3,6,7,11};
     System.out.println("Minimum Eating Speed : " + minEatingSpeed(piles, 8));
    }
}