package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ_10431 {

    static int T;
    static int N;
    static StringTokenizer st;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new int[20];
            for (int j=0; j<20; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int res = 0;

            for (int j=0; j<20; j++){
                for (int k=0; k<j; k++) {
                    if (arr[j] < arr[k]) {
                        res++;
                    }
                }
            }
            sb.append(N + " " + res).append("\n");
        }
        System.out.println(sb);
    }
}
