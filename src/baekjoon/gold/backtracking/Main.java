package baekjoon.gold.backtracking;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] res;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        res = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            // 스택이 비어있지 않고, 현재 탑이 스택의 top에 있는 탑보다 높거나 같으면
            // 스택에서 제거 (현재 탑이 그 탑들의 레이저를 받을 수 없음)
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            // 스택이 비어있으면 레이저를 받을 탑이 없음 (0)
            // 스택이 비어있지 않으면 스택의 top이 레이저를 받는 탑
            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peek() + 1; // 1-indexed
            }

            // 현재 탑을 스택에 추가
            stack.push(i);
        }


        StringBuilder sb = new StringBuilder();

        for (int i=0; i<N; i++) {
            sb.append(res[i]).append(" ");
        }

        System.out.println(sb.toString());


    }
}
