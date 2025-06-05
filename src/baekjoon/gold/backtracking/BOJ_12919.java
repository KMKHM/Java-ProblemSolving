package baekjoon.gold.backtracking;

import java.io.*;

public class BOJ_12919 {

    static boolean flag;
    static String s;
    static String t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();
        backtracking(new StringBuilder(s));
        System.out.println(flag ? 1 : 0);
    }

    static void backtracking(StringBuilder sb) {
        if (flag) return;

        String curr = sb.toString();

        if (!t.contains(curr) && !t.contains(new StringBuilder(curr).reverse().toString())) {
            return;
        }

        if (curr.length() == t.length()) {
            if (curr.equals(t)) flag = true;
            return;
        }

        // A 추가
        backtracking(new StringBuilder(curr).append("A"));
        // B 추가하고 뒤집기
        backtracking(new StringBuilder(curr).append("B").reverse());
    }
}
