package sword;

/**
 * author: cshuo
 * date: 2017/7/23
 * version: 1.0
 * description: 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 思路: 对于字符串类型的首个重复或首个不重复字符, 直接使用hash, 因为字符个数是常数个, 空间是O(1).
 */
public class FirstAppearanceOnce {
    //Insert one char from stringstream
    private int[] position = new int[256];
    private int index = 0;

    public FirstAppearanceOnce() {
        for(int i=0; i<256; i++) position[i] = -1;
    }

    public void Insert(char ch)
    {
        if(position[ch] == -1) position[ch] = index;
        else position[ch] = -2;
        index++;
    }

    public char FirstAppearingOnce()
    {
        int minIndex = Integer.MAX_VALUE;
        char rs=0;
        for(int i=0; i<256; i++) {
            if(position[i] >-1 && position[i] < minIndex) {
                rs = (char)i;
                minIndex = position[i];
            }
        }
        return minIndex == Integer.MAX_VALUE ? '#':rs;
    }
}
