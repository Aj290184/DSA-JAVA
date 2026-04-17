class ValidPalindrome {
    public static boolean isPalindrome(String str) {
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "");
        String value = cleaned.toLowerCase();
        String reversed = new StringBuilder(value).reverse().toString();
        
        return value.equals(reversed);
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));
    }
}