import java.util.*;

class DecodeString {
    public static String decodeString(String s) {

        Deque<Integer> countStack = new ArrayDeque<>(); 
        Deque<StringBuilder> stringStack = new ArrayDeque<>();

        StringBuilder curr = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }

            else if(ch == '['){
                countStack.push(num);
                stringStack.push(curr);

                num = 0;
                curr = new StringBuilder();
            }
            else if(ch == ']'){
                int repeat = countStack.pop();
                StringBuilder prev = stringStack.pop();

                for(int i = 0; i < repeat; i++){
                    prev.append(curr);
                }

                curr = prev;
            }
            else{
                curr.append(ch);
            }
        }

        return curr.toString();
    }
    public static void main(String[] args) {
     String str = "3[a2[c]]";
     System.out.println("Decode String : " + decodeString(str));
    }
}