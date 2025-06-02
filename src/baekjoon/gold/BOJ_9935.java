import java.io.*;
import java.util.*;

public class BOJ_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String total = br.readLine().trim();
        String sub = br.readLine().trim();
        int m = sub.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < total.length(); i++) {
            stack.push(total.charAt(i));

            if (stack.size() >= m) {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (stack.get(stack.size() - m + j) != sub.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    for (int j = 0; j < m; j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) sb.append(c);
            System.out.println(sb.toString());
        }
    }
}