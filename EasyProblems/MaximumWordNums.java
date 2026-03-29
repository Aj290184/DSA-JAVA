class MaximumWordNums {
    public static int mostWordsFound(String[] sentences) {
        int maxWords = 0;

        for (String sentence : sentences) {
            int words = 1;

            for (char ch : sentence.toCharArray()) {
                if(ch == ' '){
                    words++;
                }
            }
            maxWords = Math.max(maxWords, words);
        }
        return maxWords;
    }

    public static void main(String[] args) {
        String sentences[] = {
            "alice and bob love leetcode",
            "i think so too",
            "this is great thanks very much"
        };

        int result = mostWordsFound(sentences);
        System.out.println("Maximum words in a sentence : " + result);
    }
}