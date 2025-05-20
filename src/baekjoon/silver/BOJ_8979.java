package baekjoon.silver;

import java.io.*;
import java.util.*;

public class BOJ_8979 {

    static int N;
    static int K;
    static int[][] arr;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) return b[1] - a[1];
            if (a[2] != b[2]) return b[2] - a[2];
            return b[3] - a[3];
        });

        int rank = 1;

        for (int i = 0; i < N; i++) {
            if (arr[i][0] == K) {
                System.out.println(rank);
                return;
            }
            if (i < N - 1) {
                if (arr[i][1] != arr[i + 1][1] || arr[i][2] != arr[i + 1][2] || arr[i][3] != arr[i + 1][3]) {
                    rank = i + 2;
                }
            }
        }

    }

}
