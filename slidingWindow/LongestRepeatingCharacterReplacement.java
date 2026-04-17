class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int left = 0, maxfreq = 0, maxLen = 0;

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            freq[ch - 'A']++;

            maxfreq = Math.max(maxfreq, freq[ch - 'A']);

            if((right - left + 1) - maxfreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println("Max length : " + characterReplacement(s, k));
    }
}