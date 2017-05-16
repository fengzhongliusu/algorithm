package sword;

/**
 * author: cshuo
 * date: 2017/5/6
 * version: 1.0
 * description:
 */
public class VeriPostSeq {
    public static void main(String[] args) {
        int[] nums = {7,4,6,5};
        System.out.println(VerifySquenceOfBST(nums));
    }
    public static boolean VerifySquenceOfBST(int [] sequence) {
        return sequence.length >= 1 && checkPostSeq(sequence, 0, sequence.length - 1);
    }

    public static boolean checkPostSeq(int[] seq, int l, int r){
        // 左子树为空或右子树为空
        if(l >= r) return true;
        int lr = l;
        while(seq[lr] < seq[r]) lr++;
        for(int i=lr; i<r; i++)
            if(seq[i] < seq[r]) return false;
        return checkPostSeq(seq, l, lr-1) && checkPostSeq(seq, lr, r-1);
    }
}
