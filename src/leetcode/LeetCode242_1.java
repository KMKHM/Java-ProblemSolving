package leetcode;

class LeetCode242_1{
    public boolean isAnagram(String s, String t) {

        int[] arr = new int[26];

        for (char c : s.toCharArray()) {
            arr[c-'a']++;
        }

        for (char c: t.toCharArray()) {
            arr[c-'a']--;
        }

        for (int num : arr) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
