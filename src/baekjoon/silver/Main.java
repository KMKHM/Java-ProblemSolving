package baekjoon.silver;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            arr[i] = new int[] {Integer.parseInt(st.nextToken()), i+1};
        }
        // 사람들은 자기보다 큰 사람이 왼쪽에 몇 명 있었는지만을 기억
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        System.out.println(Arrays.deepToString(arr));
    }
}
