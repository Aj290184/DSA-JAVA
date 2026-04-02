import java.util.*;

class BoatsSavePeople {
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {
            if(people[left] + people[right] <= limit){
                left++;
            }
            right--;
            boats++;
        }

        return boats;
    }
    public static void main(String[] args) {
     int people[] = {3,2,2,1};
     System.out.println("Output : " + numRescueBoats(people, 3));
    }
}