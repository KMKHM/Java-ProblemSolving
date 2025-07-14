package leetcode;

import java.util.*;

public class LeetCode1290 {
    public int getDecimalValue(ListNode head) {

        List<Integer> list = new ArrayList<>();
        int size=0;
        while (head != null) {
            list.add(head.val);
            head = head.next;
            size++;
        }

        int res = 0;
        int carry = 0;

        for (int i=size-1; i>=0; i--) {
            res += list.get(i) == 1 ?  Math.pow(2, carry) : 0;
            carry++;
        }
        return res;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
