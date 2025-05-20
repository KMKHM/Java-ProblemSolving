package baekjoon.silver;

import java.io.*;
import java.util.*;

public class BOJ_4659 {

    static StringBuilder sb = new StringBuilder();
    static String vowel = "aeiou";
    static String consonant = "bcdfghjklmnpqrstvwxyz";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s.equals("end")) {
                break;
            }
            if (check(s)) {
                sb.append("<").append(s).append("> is acceptable.\n");
            } else {
                sb.append("<").append(s).append("> is not acceptable.\n");
            }
        }

        System.out.println(sb);
    }

    static boolean check(String s) {

        boolean flag = false;
        for (char c: vowel.toCharArray()) {
            if (s.contains(String.valueOf(c))) {
                flag=true;
            }
        }

        if (!flag) {
            return false;
        }

        int vowelCount = 0;
        int consonantCount = 0;

        for (char c : s.toCharArray()) {
            if (vowel.contains(String.valueOf(c))) {
                vowelCount++;
                if (vowelCount >= 3) {
                    return false;
                }
                consonantCount = 0;
            } else if (consonant.contains(String.valueOf(c))) {
                consonantCount++;
                if (consonantCount >= 3) {
                    return false;
                }
                vowelCount = 0;
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                if (s.charAt(i) != 'e' && s.charAt(i) != 'o') {
                    return false;
                }
            }
        }

        return true;

    }
}
