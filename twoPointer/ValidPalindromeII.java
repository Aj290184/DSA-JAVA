class ValidPalindromeII {
    public static boolean validPalindrome(String str) {
     String cleaned = str.replaceAll("[^a-zA-Z0-9]", "");
     String reversed = new StringBuilder(cleaned).reverse().toString();
     return cleaned.equals(reversed);
    }
    public static void main(String[] args) {
     String str = "abbadc";
     System.out.println(validPalindrome(str));
    }
}