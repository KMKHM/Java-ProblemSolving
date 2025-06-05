package baekjoon.gold;

import java.io.*;
import java.util.*;

public class BOJ_20055 {

    static int N, K;
    static int[] arr;
    static boolean[] robot;
    static int res;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[2 * N];
        robot = new boolean[2 * N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (countZero() < K) {
            res++;
            rotate();
            moveRobot();
            putRobot();
        }

        System.out.println(res);
    }

    static void rotate() {
        // 내구도 회전
        int lastDurability = arr[2 * N - 1];
        for (int i = 2 * N - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = lastDurability;

        // 로봇 회전
        for (int i = 2 * N - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;

        // 내리는 위치에서 로봇 내림
        robot[N - 1] = false;
    }

    static void moveRobot() {
        for (int i = N - 2; i >= 0; i--) {
            if (robot[i] && !robot[i + 1] && arr[i + 1] > 0) {
                robot[i] = false;
                robot[i + 1] = true;
                arr[i + 1]--;
            }
        }

        // 내리는 위치에서 로봇 내림
        robot[N - 1] = false;
    }

    static void putRobot() {
        if (!robot[0] && arr[0] > 0) {
            robot[0] = true;
            arr[0]--;
        }
    }

    static int countZero() {
        int cnt = 0;
        for (int durability : arr) {
            if (durability == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}