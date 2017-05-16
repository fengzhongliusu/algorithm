package exam;

import java.util.Arrays;

/**
 * author: cshuo
 * date: 2017/4/28
 * version: 1.0
 * description:
 */
public class IBMset {
    private static final int EMPTY = 0;

    private int[] arr;
    private int limit;

    public IBMset(int limit) {
        arr = new int[limit];
        this.limit = limit;
    }

    public boolean add(int num) {
        int index = num % limit;
        if (arr[index] == EMPTY) {
            arr[index] = num;
            return true;
        } else if (arr[index] == num) {
            return false;
        } else {
            int tmp = (index + 1) % limit;
            int firstEmpty = -1;
            // num exists , find the first empty , no empty
            while (tmp != index) {
                if (arr[tmp] == EMPTY) {
                    if (firstEmpty == -1) firstEmpty = tmp;
                } else if (arr[tmp] == num)
                    return false;
                tmp = (tmp + 1) % limit;
            }
            if (firstEmpty != -1) {
                arr[firstEmpty] = num;
                return true;
            }
            return false;
        }
    }

    public boolean remove(int num) {
        int index = num % limit;
        int walk = 0;
        while (arr[index] != num && walk++ < limit) {
            index = (index + 1) % limit;
        }
        if (arr[index] == num) {
            arr[index] = EMPTY;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        IBMset s = new IBMset(10);

        s.add(2);s.add(12);s.add(22);s.add(32);s.add(42);
        s.add(7);
        s.add(15);
        System.out.println(Arrays.toString(s.arr));
        s.remove(2);s.remove(12);s.remove(22);
        System.out.println(Arrays.toString(s.arr));
        s.add(15);
        System.out.println(Arrays.toString(s.arr));

    }
}

