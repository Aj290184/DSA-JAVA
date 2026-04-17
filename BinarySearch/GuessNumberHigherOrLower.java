class GuessGame {
    int pick = 6;
    int guess(int num){
        if(num > pick) return -1;
        else if(num < pick) return 1;
        else return 0;
    }
}

public class GuessNumberHigherOrLower extends GuessGame {

    public int GuessNumber(int n) {
        int left = 0, right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int res = guess(mid);

            if(res == 0){
                return mid;
            }
            else if(res == -1){
                right = mid -1;
            }
            else{
                left = mid + 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        GuessNumberHigherOrLower sol = new GuessNumberHigherOrLower();

        int n = 10;
        int result = sol.GuessNumber(n);

        System.out.println("Guessed Number : " + result);
    }
}