package exam;

import java.util.Scanner;
import java.util.Stack;

public class WAP0001 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, x, ans = 0;
        n = in.nextInt();
        int[] num = new int[n];
        for (int i = 1; i <= n; i++) {
            x = in.nextInt();
            num[i - 1] = x;
        }

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> s = new Stack<>();

        s.push(num[0]);

        for (int i = 1; i < n; ++i) {
            if (num[i] < s.peek()) {
                left[i] = s.peek();
                s.push(num[i]);
            } else if (num[i] > s.peek()) {
                s.pop();
                while (!s.empty()) {

                    if (num[i] < s.peek()) {
                        left[i] = s.peek();
                        break;
                    }
                    s.pop();
                }
                s.push(num[i]);
            }
        }


        s = new Stack<>();
        s.push(num[num.length - 1]);

        for (int i = n - 2; i >= 0; --i) {
            if (num[i] < s.peek()) {
                right[i] = s.peek();
                s.push(num[i]);
            } else if (num[i] > s.peek()) {
                s.pop();
                while (!s.empty()) {

                    if (num[i] < s.peek()) {
                        right[i] = s.peek();
                        break;
                    }
                    s.pop();
                }
                s.push(num[i]);
            }
        }

        for(int i=0; i<n; i++)
            System.out.print(left[i] + " ");
        System.out.println();
        for(int i=0; i<n; i++)
            System.out.print(right[i] + " ");
        System.out.println();

        for (int i = 0; i < n; ++i) {
            if (left[i] != 0)
                ans = Math.max(ans, num[i] ^ left[i]);
            if(right[i] != 0)
                ans = Math.max(ans, num[i] ^ right[i]);
        }

        System.out.println(ans);
    }
}
