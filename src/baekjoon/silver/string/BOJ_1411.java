package baekjoon.silver.string;

import java.util.*;
import java.io.*;

public class BOJ_1411 {
    static int N;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int res = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isSimilar(arr[i], arr[j])) {
                    res++;
                }
            }
        }

        System.out.println(res);
    }

    static boolean isSimilar(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Character> map1to2 = new HashMap<>();
        Map<Character, Character> map2to1 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            // s1의 문자 c1이 이미 매핑되어 있는지 확인
            if (map1to2.containsKey(c1)) {
                if (map1to2.get(c1) != c2) {
                    return false;
                }
            } else {
                map1to2.put(c1, c2);
            }

            // s2의 문자 c2가 이미 매핑되어 있는지 확인
            if (map2to1.containsKey(c2)) {
                if (map2to1.get(c2) != c1) {
                    return false;
                }
            } else {
                map2to1.put(c2, c1);
            }
        }

        return true;
    }
}