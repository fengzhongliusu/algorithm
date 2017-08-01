package sword;
import java.util.*;

/**
 * Created by cshuo on 2017/7/23
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数
 * 序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有
 * 和为S的连续正数序列? Good Luck!
 */
public class FindContinuesSeq {

    /**
     * 主要利用了连续正数的求和公式来计算
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> rs = new ArrayList<>();
        for(int i=1; i <= sum/2; i++) {
            for(int j=i+1; j<= sum/2+1; j++) {
                if(j*j - i*i + i + j > 2 * sum) break;
                if(j*(j+1) - i*(i-1) == 2 * sum) {
                    ArrayList<Integer> solution = new ArrayList<>();
                    for(int k=i; k <=j; k++) solution.add(k);
                    rs.add(solution);
                }
            }
        }
        return rs;
    }
}
