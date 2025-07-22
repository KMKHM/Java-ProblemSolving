package baekjoon.silver;

import java.io.*;
import java.util.*;

public class Main {

    static Map<String, Integer> map = new HashMap<>();
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String s;

        while ((s = br.readLine()) != null) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        // 결과 출력을 정렬된 순서로
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }



    }
}
