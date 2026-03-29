import java.util.*;

class EncodeDecode {
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));

            String word = str.substring(j + 1, j + 1 + len);
            result.add(word);

            i = j + 1 + len;
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("Hello", "World");

        String encoded = encode(input);
        System.out.println("Encoded : " + encoded);

        List<String> decoded = decode(encoded);
        System.out.println("Decoded : " + decoded);
    }
}