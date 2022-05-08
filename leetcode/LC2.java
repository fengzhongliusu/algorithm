package leetcode;

import java.math.BigInteger;

/**
 * Created by cshuo on 2021/8/15
 */
public class LC2 {
    public static void main(String[] args) {
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = l1, h2 = l2;
        while (h1 != null && h2 != null) {
            h1 = h1.next;
            h2 = h2.next;
        }
        if (h2 == null) {
            h1 = l1;
            h2 = l2;
        } else {
            h1 = l2;
            h2 = l1;
        }
        int sum, mod = 0;
        while (h1 != null) {
            if (h2 == null) {
                sum = h1.val + mod;
            } else {
                sum = h2.val + h1.val + mod;
            }
            if (sum < 10) {
                h1.val = sum;
                mod = 0;
            } else {
                h1.val = sum % 10;
                mod = 1;
            }
            h1 = h1.next;
            h2 = h2.next;
        }

        h1 = l1;
        h2 = l2;
        while (h1.next != null && h2.next != null) {
            h1 = h1.next;
            h2 = h2.next;
        }
        if (h2.next == null) {
            if (mod == 1) {
                ListNode n = new ListNode(1);
                while (h1.next != null) h1 = h1.next;
                h1.next = n;
            }
            return l1;
        } else {
            if (mod == 1) {
                ListNode n = new ListNode(1);
                while (h2.next != null) h2 = h2.next;
                h2.next = n;
            }
            return l2;
        }
    }
}
