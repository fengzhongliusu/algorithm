package exam;

import java.util.Arrays;

/**
 * author: cshuo
 * date: 2017/4/28
 * version: 1.0
 * description:
 */
public class IBMSet1 {
    private int[] arr;
    private int limit;
    private static final int EMPTY = 0;
    private static final int DELETED = -1;

    public static void main(String[] args) {
        IBMSet1 s = new IBMSet1(10);

        s.add(2);s.add(12);s.add(22);s.add(32);s.add(42);
        s.add(7);
        s.add(15);
        System.out.println(Arrays.toString(s.arr));
        s.remove(32);
        System.out.println(Arrays.toString(s.arr));
        s.add(15);
        System.out.println(Arrays.toString(s.arr));
    }

    public IBMSet1(int limit) {
        arr = new int[limit];
        this.limit = limit;
    }

    public boolean add(int num) {
        int index = num % limit, walk = 0;
        int firstDelete = -1;
        while(arr[index] != num && arr[index] != EMPTY && walk++ < limit){
            if(firstDelete == -1 && arr[index] == DELETED)
                firstDelete = index;
            index = (index + 1) % limit;
        }

        if(arr[index] == num){
            return false;
        } else if(arr[index] == EMPTY){
            // 插入到标记为DELETED的位置
            if(firstDelete != -1) arr[firstDelete] = num;
            // 没有标记为DELETED的位置
            else arr[index] = num;
            return true;
        } else {
            // 有标记为DELETED的位置, 成功插入.
            if(firstDelete != -1){
                arr[firstDelete] = num;
                return true;
            }
            else return false;
        }
    }

    public boolean remove(int num) {
        int index = num % limit, walk=0;
        while(arr[index] != num && arr[index] != EMPTY && walk++ < limit){
            index = (index + 1) % limit;
        }
        if(arr[index] == num){
            arr[index] = DELETED;
            return true;
        }
        return false;
    }
}
