package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ_3758 {
    static int T;
    static int n;
    static int k;
    static int t;
    static int m;
    static int[][] arr;
    static StringTokenizer st;
    static Map<Integer, Integer> map;
    static Map<Integer, Integer> lastSubmit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            // 팀 개수
            n = Integer.parseInt(st.nextToken());
            // 문제 개수
            k = Integer.parseInt(st.nextToken());
            // 내 팀id
            t = Integer.parseInt(st.nextToken());
            // 로그 엔트리 수
            m = Integer.parseInt(st.nextToken());

            arr = new int[n+1][k+1];
            map = new HashMap<>();
            lastSubmit = new HashMap<>();

            for (int j=0; j<m; j++) {
                st = new StringTokenizer(br.readLine());
                // 팀 id
                int teamId = Integer.parseInt(st.nextToken());
                // 문제 id
                int problemId = Integer.parseInt(st.nextToken());
                // 문제 점수
                int score = Integer.parseInt(st.nextToken());

                map.put(teamId, map.getOrDefault(teamId, 0) + 1);
                lastSubmit.put(teamId, j+1);

                if (arr[teamId][problemId] == 0) {
                    arr[teamId][problemId] = score;
                } else {
                    arr[teamId][problemId] = Math.max(arr[teamId][problemId], score);
                }
            }


            int[][] res = new int[n+1][4];

            for (int x=1; x<=n; x++) {

                res[x][0] = getSum(arr[x]); // 점수
                res[x][1] = map.get(x); // 제출 횟수
                res[x][2] = lastSubmit.get(x); // 마지막 제출시간
                res[x][3] = x; // 팀 id
            }

            Arrays.sort(res, (a, b) -> {
                if (a[0] != b[0]) return b[0] - a[0];
                if (a[1] != b[1]) return a[1] - b[1];
                if (a[2] != b[2]) return a[2] - b[2];
                return a[3] - b[3];
            });

            int cnt=1;

            for (int y=0; y<=res.length; y++) {
                if (res[y][3] == t) {
                    sb.append(cnt).append("\n");
                    break;
                }
                cnt++;
            }

        }
        System.out.println(sb);

    }

    static int getSum(int[] arr) {
        int val=0;
        for (int i : arr) {
            val += i;
        }
        return val;
    }
}
