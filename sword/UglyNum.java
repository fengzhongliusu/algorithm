package sword;

/**
 * author: cshuo
 * date: 2017/7/10
 * version: 1.0
 * description:
 */
public class UglyNum {

    public static void main(String[] args) {
        System.out.println(getUglyNum(10));
    }


    /**
     * 计算出从小到大的丑数, 空间换时间.
     * 每次更新一个丑数, 方法是将当前已找到丑数乘以2,3,5;找到大于当前最大丑数的最小的一个; 三个变量指示乘法开始的位置.(没必要每次从头开始)
     */
    public static int getUglyNum(int index){
        if(index < 1) return 0;
        int[] uglyNum = new int[index];
        int pMulti2 = 0, pMulti3 = 0, pMulti5 = 0, nextPos=1;
        uglyNum[0] = 1;
        while(nextPos < index){
            uglyNum[nextPos] = Math.min(Math.min(uglyNum[pMulti2] * 2, uglyNum[pMulti3] * 3), uglyNum[pMulti5]*5);
            while(uglyNum[pMulti2] * 2 <= uglyNum[nextPos]) pMulti2++;
            while(uglyNum[pMulti3] * 3 <= uglyNum[nextPos]) pMulti3++;
            while(uglyNum[pMulti5] * 5 <= uglyNum[nextPos]) pMulti5++;
            nextPos++;
        }
        return uglyNum[nextPos-1];
    }


    /**
     * 逐个判断数字是否是丑数.
     */
    public static int GetUglyNumber(int index) {
        int i, count = 0;
        if(index < 1) return 0;
        for(i = 1; count < index; i++) {
            if(isUgly(i)) count++;
        }
        return i;
    }

    public static boolean isUgly(int num){
        while(num % 2 == 0) num /= 2;
        while(num % 3 == 0) num /= 2;
        while(num % 5 == 0) num /= 2;
        return num == 1;
    }
}
