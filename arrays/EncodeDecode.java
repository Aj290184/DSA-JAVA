import java.util.*;

class EncodeDecode {
    public static String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();

        for (String s : strs) {
            str.append(s.length()).append("#").append(s);
        }

        return str.toString();
    }

    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(str.substring(i,j));
            String word = str.substring(j + 1, j + 1 + len);
            result.add(word);

            i = j + 1 + len;
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("Hello");
        input.add("World");

        String encoded = encode(input);
        System.out.println("Encoded : " + encoded);

        List<String> decoded = decode(encoded);
        System.out.println("Decoded : " + decoded);
    }
}