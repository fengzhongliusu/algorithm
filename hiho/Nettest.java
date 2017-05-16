package hiho;

/**
 * author: cshuo
 * date: 2017/3/24
 * version: 1.0
 * description:
 */
import java.util.Scanner;

public class Nettest{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            int n = in.nextInt();
            long r = in.nextLong();
            long avg = in.nextLong();
            long[][] arr = new long[n][2];
            long total = avg * n;//需要的分数
            long score = 0;//现在的分数
            for (int i = 0; i < n; i++) {
                arr[i][0] = in.nextLong();//平时成绩
                arr[i][1] = in.nextLong();//时间
                score += arr[i][0];
            }
            sort(arr);
            long time = 0;
            int i = 0;
            while (score < total && i < n) {
                if (arr[i][0] < r) {
                    time += arr[i][1];
                    score++;
                    arr[i][0] += 1;
                } else {
                    i++;
                }
            }
            System.out.println(time);
        }
        in.close();
    }
    //对时间进行排序
    public static void sort(long[][]a) {

        for (int i = 0; i < a.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j][1] > a[j + 1][1]) {
                    long temp = a[j][0];
                    long temp2 = a[j][1];
                    a[j][0] = a[j + 1][0];
                    a[j + 1][0] = temp;
                    a[j][1] = a[j + 1][1];
                    a[j + 1][1] = temp2;
                    flag = false;
                }
            }
            if (flag)
                return;
        }
    }
}
