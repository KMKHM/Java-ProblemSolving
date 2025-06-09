package baekjoon.gold.graph;

import java.io.*;
import java.util.*;

public class BOJ_16947 {

    static int N;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static boolean[] isCycle;
    static int[] distance;
    static boolean foundCycle = false;
    static int cycleStart = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 양방향 간선 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[N + 1];
        isCycle = new boolean[N + 1];
        distance = new int[N + 1];
        Arrays.fill(distance, -1); // 거리 초기화

        // 1단계: 사이클 찾기
        dfs(1, -1);

        // 2단계: 사이클 노드들로부터 BFS 시작
        bfs();

        // 3단계: 각 노드가 사이클까지 얼마나 떨어져 있는지 출력
        for (int i = 1; i <= N; i++) {
            System.out.print(distance[i] + " ");
        }
    }

    // DFS로 사이클 탐색
    static boolean dfs(int cur, int parent) {
        visited[cur] = true;

        for (int next : graph.get(cur)) {
            if (next == parent) continue; // 부모는 무시 (양방향 방지용)

            if (!visited[next]) {
                if (dfs(next, cur)) {
                    // 사이클에 포함된 노드를 마킹하는 단계
                    if (!foundCycle) isCycle[cur] = true;
                    if (cur == cycleStart) foundCycle = true;
                    return true;
                }
            } else {
                // 방문했고 부모가 아니면 사이클 발견
                cycleStart = next;
                isCycle[cur] = true;
                return true;
            }
        }

        return false;
    }

    // 사이클에서부터 거리 측정 BFS
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        // 사이클 노드들을 큐에 넣고 시작
        for (int i = 1; i <= N; i++) {
            if (isCycle[i]) {
                distance[i] = 0;
                q.offer(i);
            }
        }

        // BFS로 거리 계산
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                if (distance[next] == -1) { // 아직 방문 안한 노드만
                    distance[next] = distance[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }
}