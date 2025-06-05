package leetcode;

public class LeetCode1061 {
    public static int[] parent = new int[26];

    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        for (int i=0; i<26; i++) {
            parent[i] = i;
        }

        int n=s1.length();

        for (int i=0; i<n; i++) {
            int a = s1.charAt(i) - 'a';
            int b = s2.charAt(i) - 'a';

            union(a, b);
        }



        char[] res=new char[baseStr.length()];

        for (int i=0; i<baseStr.length(); i++) {
            int x = find(baseStr.charAt(i) - 'a');
            res[i] = (char)(x+'a');
        }
        return new String(res);
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }

    public static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        parent[Math.max(parentA, parentB)] = Math.min(parentA, parentB);
    }
}
