package leetcode;
import java.util.*;


/**
 * Created by cshuo on 2017/8/8
 */
public class LC421 {
    public static void main(String[] args) {
//        int[] nums = new int[]{32,18,33,42,29,20,26,36,15,46};
        int[] nums = new int[]{3, 10, 5, 25, 2, 8};
        System.out.println(findMaxXor(nums));
    }

    static class Trie {
        Trie[] child = new Trie[2];
    }

    /**
     * 基于字典树, 先遍历数组简历字典树，在遍历一次字典树得到最大的异或值(根据每个bit位，向相反的方向走).
     */
    public static int findMaxXor(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Trie root = new Trie();
        for(int e: nums) {
            Trie ptr = root;
            for(int i=31; i>=0; i--) {
                int bit = e>>i&1;
                if(ptr.child[bit] == null) ptr.child[bit] = new Trie();
                ptr = ptr.child[bit];
            }
        }
        int maxXor = 0, sum;
        for(int e: nums) {
            Trie ptr = root;
            sum = 0;
            for(int i=31; i>=0; i--) {
                int bit = e>>i&1;
                if(ptr.child[bit^1] != null){
                    sum += (1<<i);
                    ptr = ptr.child[bit^1];
                } else {
                    ptr = ptr.child[bit];
                }
            }
            if(sum > maxXor) maxXor = sum;
        }
        return maxXor;
    }

    /**
     * NOTE: WRONG ANSWER!!!
     */
    public static int findMaximumXOR(int[] nums) {
        List<Integer> oneSet = new ArrayList<>(), zeroSet = new ArrayList<>();
        int i;
        for(i=31; i>=0; i--) {
            oneSet.clear();
            zeroSet.clear();
            for(int e: nums) {
                if((e&1<<i) == 0) zeroSet.add(e);
                else oneSet.add(e);
            }
            if(!zeroSet.isEmpty() && !oneSet.isEmpty()) break;
        }
        System.out.println(i);
        if(zeroSet.isEmpty() || oneSet.isEmpty()) return 0;
        System.out.println(zeroSet);
        System.out.println(oneSet);
        for(i=i-1; i>=0; i--) {
            int zcountz = 0, zcounto = 0, ocountz = 0, ocounto = 0;
            for(int e: zeroSet)  if((e&1<<i) == 0) zcountz++; else zcounto++;
            for(int e: oneSet)  if((e&1<<i) == 0) ocountz++; else ocounto++;
            if(zcountz == 0 && ocountz == 0 || zcounto == 0 && ocounto == 0) continue;
            if(zcountz == 0) {
                Iterator<Integer> itr = oneSet.iterator();
                while(itr.hasNext()) {
                    int it  = itr.next();
                    if((it&1<<i) != 0) itr.remove();
                }
            }
            if(zcounto == 0) {
                Iterator<Integer> itr = oneSet.iterator();
                while(itr.hasNext()) {
                    int it  = itr.next();
                    if((it&1<<i) == 0) itr.remove();
                }
            }
            if(ocountz == 0) {
                Iterator<Integer> itr = zeroSet.iterator();
                while(itr.hasNext()) {
                    int it  = itr.next();
                    if((it&1<<i) != 0) itr.remove();
                }
            }
            if(ocounto == 0) {
                Iterator<Integer> itr = zeroSet.iterator();
                while(itr.hasNext()) {
                    int it  = itr.next();
                    if((it&1<<i) == 0) itr.remove();
                }
            }
        }
        if(zeroSet.isEmpty() || oneSet.isEmpty()) return 0;
        System.out.println(zeroSet);
        System.out.println(oneSet);
        return zeroSet.get(0) ^ oneSet.get(0);
    }
}
