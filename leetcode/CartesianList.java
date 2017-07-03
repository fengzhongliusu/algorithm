package leetcode;

import java.util.*;

/**
 * author: cshuo
 * date: 2017/6/15
 * version: 1.0
 * description: 若干个数组, 数组元素不重复, 每个数组中取出一个元素, 组成一个数组,列举出所有可能, (类似数组的笛卡尔乘积);
 * solution: 利用backtrack的思路, 进行回溯, 即可解决;
 */
public class CartesianList {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1,2,3));
        lists.add(Arrays.asList(4,5,6));
        lists.add(Arrays.asList(7,8,9));
        List<List<Integer>> result = new ArrayList<>();

        getCartesian(lists, result, 0, new ArrayList<Integer>());
        System.out.println(result.size());
        System.out.println(result);
    }

    public static void getCartesian(List<List<Integer>> lists, List<List<Integer>> result, int depth, List<Integer> current){
        if(depth == lists.size()){
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for(int i=0; i<lists.get(depth).size(); i++){
            current.add(lists.get(depth).get(i));
            getCartesian(lists, result, depth + 1, current);
            current.remove(current.size()-1);
        }
    }
}
