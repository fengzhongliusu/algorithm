package exam;

import java.util.Arrays;

/**
 * author: cshuo
 * date: 2017/4/28
 * version: 1.0
 * description:
 */

public class IBMSetOrigin // suppose use int only
{
    private int[] arr;
    private int limit;
    private static final int EMPTY = 0;


    public IBMSetOrigin(int limit) // you don't need to think about auto-dilatation
    {
        arr = new int[limit];
        this.limit = limit;
    }

    public boolean add(int num) // return true if success, return false
    {
        int index = num % limit;
        int walk = 0;
        while (arr[index] != EMPTY && arr[index] != num && walk++ < limit) {
            index = (index + 1) % limit;
        }
        if (arr[index] == EMPTY) {
            arr[index] = num;
            return true;
        }
        return false;
    }

    public boolean remove(int num) // return true if success, return false
    {
        int index = num % limit , walk=0;
        while (arr[index] != num && arr[index] != EMPTY && walk++ < limit) {
            index = (index + 1) % limit;
        }
        if (arr[index] == num) {
            arr[index] = EMPTY;
            index = (index + 1) % limit;
            //
            while (arr[index] != EMPTY && arr[index] % limit != index) {
                if (index == 0) arr[limit - 1] = arr[index];
                else arr[index - 1] = arr[index];
                index = (index + 1) % limit;
            }
            // 最后置为EMPTY
            if (index == 0) arr[limit - 1] = EMPTY;
            else arr[index - 1] = EMPTY;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        IBMSetOrigin s = new IBMSetOrigin(10);
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
