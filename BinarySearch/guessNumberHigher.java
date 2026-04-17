class GuessGame {
    int pick = 6;

    int guess(int num) {
        if (num > pick) return -1;
        else if (num < pick) return 1;
        else return 0;
    }
}

public class guessNumberHigher extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);

            if (res == 0) {
                return mid;
            } else if (res == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        guessNumberHigher sol = new guessNumberHigher();
        int n = 10;
        System.out.println(sol.guessNumber(n));
    }
}