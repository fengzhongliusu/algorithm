package leetcode;

import java.util.Stack;

/**
 * Created by cshuo on 2021/8/16
 */
public class LC445 {
    public static void main(String[] args) {
        ListNode h = new ListNode(5);

        ListNode l = new ListNode(5);
        addTwoNumbers(h, l);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = l1, h2 = l2;
        int cnt = 0;
        boolean lSmaller = false;
        while (h1 != null || h2 != null) {
            if (h1 == null || h2 == null) {
                cnt += 1;
                lSmaller = h1 == null;
            }
            if (h1 != null) h1 = h1.next;
            if (h2 != null) h2 = h2.next;
        }

        Stack<int[]> sk = new Stack<>();
        h1 = l1;
        h2 = l2;
        if (cnt > 0) {
            if (lSmaller) {
                for (int i = 0; i < cnt; i++, h2 = h2.next) sk.push(new int[]{0, h2.val});
            } else {
                for (int i = 0; i < cnt; i++, h1 = h1.next) sk.push(new int[]{h1.val, 0});
            }
        }
        while (h1 != null && h2 != null) {
            sk.push(new int[]{h1.val, h2.val});
            h1 = h1.next;
            h2 = h2.next;
        }
        ListNode prev = null;
        int carry = 0;
        while (!sk.isEmpty() || carry > 0) {
            int sum = 0;
            if (sk.isEmpty()) {
                sum = carry;
                carry = 0;
            } else {
                int[] pair = sk.pop();
                sum = pair[0] + pair[1] + carry;
                if (sum >= 10) {
                    sum = sum % 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
            }
            ListNode cur = new ListNode(sum);
            cur.next = prev;
            prev = cur;
        }
        return prev;
    }
}
