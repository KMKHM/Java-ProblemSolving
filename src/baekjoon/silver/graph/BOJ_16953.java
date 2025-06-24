
package baekjoon.silver.graph;

import java.io.*;
import java.util.*;

public class BOJ_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken()); // Integer -> Long 파싱
        long b = Long.parseLong(st.nextToken());
        System.out.println(bfs(a, b));
    }

    static long bfs(long start, long end) {
        if (start == end) return 1; // 시작점과 끝점이 같은 경우 처리

        Queue<long[]> q = new LinkedList<>();
        Set<Long> visited = new HashSet<>(); // Map 대신 Set 사용

        q.offer(new long[]{start, 1});
        visited.add(start);

        while (!q.isEmpty()) {
            long[] current = q.poll();
            long cur = current[0];
            long cnt = current[1];

            // 두 가지 연산: *2, *10+1
            long[] nextNums = {cur * 2, cur * 10 + 1};

            for (long next : nextNums) {
                if (next == end) {
                    return cnt + 1;
                }

                if (next <= 1_000_000_000 && !visited.contains(next)) {
                    visited.add(next);
                    q.offer(new long[]{next, cnt + 1});
                }
            }
        }
        return -1;
    }
}