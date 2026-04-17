class CapacityShipPackages {
    public static int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        
        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if(canShip(weights, days, mid)){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }

        return low;
    }
    
    private static boolean canShip(int weights[], int days, int capacity){
        int daysUsed = 1;
        int currentLode = 0;

        for (int w : weights) {
            if(currentLode + w > capacity){
                daysUsed++;
                currentLode = w;
            }
            else{
                currentLode += w;
            }
        }

        return daysUsed <= days;
    }
    public static void main(String[] args) {
     int weights[] = {1,2,3,4,5,6,7,8,9,10};
     System.out.println("Shiping Days : " + shipWithinDays(weights, 5));
    }
}