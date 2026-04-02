class MergeStrings {
    public static String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;

        StringBuilder result = new StringBuilder();

        while (i < word1.length() || j < word2.length()) {
            if(i < word1.length()){
                result.append(word1.charAt(i));
                i++;
            }

            if(j < word2.length()){
                result.append(word2.charAt(j));
                j++;
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
     String word1 = "abc";
     String word2 = "pqr";
     System.out.println("String is : " + mergeAlternately(word1, word2));
    }
}