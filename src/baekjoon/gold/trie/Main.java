package baekjoon.gold.trie;

import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static TrieNode root = new TrieNode();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        for (int i=0; i<N; i++) {

            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            TrieNode cur = root;
            for (int j=0; j<m; j++) {
                String c = st.nextToken();
                cur = cur.children.computeIfAbsent(c, k -> new TrieNode());
                cur = cur.children.get(c);
            }



        }

    }

    static class TrieNode {
        Map<String, TrieNode> children = new HashMap<>();
    }

    static void print(String s) {
        List<String> list = new ArrayList<>(root.children.keySet());
        Collections.sort(list);
        for (String c : list) {
            sb.append(c).append("\n");
        }
    }

}
