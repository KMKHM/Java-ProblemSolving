package leetcode;

import java.util.*;

class LeetCode242_2 {
    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Character c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for (Integer num : map.values()) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
