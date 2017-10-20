package exam;

import java.util.Arrays;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class SP003
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int minNum = Integer.MAX_VALUE;
    int findMinNumberOfJuiceStalls(int numOfStalls, int[] distOfStalls,
                                   int[] juiceQuantity, int distance,
                                   int initialEnergy)
    {
        // WRITE YOUR CODE HERE
        int sum = 0;
        for(int i=0; i<numOfStalls; i++) sum += juiceQuantity[i];
        if(sum + initialEnergy < distance) return -1;
        dfs(initialEnergy, 0, 0, distance, 0, juiceQuantity, distOfStalls, true);
        return minNum == Integer.MAX_VALUE ? -1 : minNum;
    }

    public void dfs(int nowEgy, int dis, int count, int totalDis, int visIdx, int[] juiceQuantity, int[] distOfStalls, boolean canSolve) {
        if(!canSolve) return;
        if(dis == totalDis) {
            if(count < minNum) minNum = count;
        }
        else if(visIdx >= distOfStalls.length) {
            if(nowEgy < totalDis - dis) {
                canSolve = false;
            }
            dfs(0, totalDis, count, totalDis, visIdx+1, juiceQuantity, distOfStalls, canSolve);
        }
        else {
            dfs(nowEgy - distOfStalls[visIdx] + dis, distOfStalls[visIdx], count, totalDis, visIdx+1, juiceQuantity, distOfStalls, true);
            dfs(nowEgy - distOfStalls[visIdx] + dis + juiceQuantity[visIdx], distOfStalls[visIdx], count+1, totalDis, visIdx+1, juiceQuantity, distOfStalls, true);
        }
    }

    public static void main(String[] args) {
        SP003 test = new SP003();
        int[] arrs = new int[] {3,1,2};
        System.out.println(test.findMinNumberOfJuiceStalls(3, new int[]{5,7,10}, new int[]{2,3,5}, 15, 5));
    }
    // METHOD SIGNATURE ENDS
}
