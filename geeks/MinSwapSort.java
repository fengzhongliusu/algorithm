package geeks;
import java.util.*;
import javafx.util.Pair;

/**
 * 包含n个distinct元素的数组，求出将该数组排序所需的最少交换次数.
 * http://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
 */
public class MinSwapSort {
    public static int minSwaps(int[] arr)
    {
        int n = arr.length;

        // Create two arrays and use as pairs where first array is element
        // and second array is position of first element
        ArrayList <Pair<Integer, Integer> > arrpos =
                new ArrayList<>();
        for (int i = 0; i < n; i++)
            arrpos.add(new Pair<>(arr[i], i));

        Collections.sort(arrpos, (o1,o2) -> o1.getKey() - o2.getKey());
        for(Pair<Integer, Integer> p: arrpos) {
            System.out.println(p.getKey() + ": " + p.getValue());
        }

        // To keep track of visited elements. Initialize all elements as not visited or false.
        Boolean[] vis = new Boolean[n];
        Arrays.fill(vis, false);

        // Initialize result
        int ans = 0;

        // Traverse array elements
        for (int i = 0; i < n; i++)
        {
            // already swapped and corrected or already present at correct pos
            if (vis[i] || arrpos.get(i).getValue() == i)
                continue;

            // find out the number of  node in this cycle and add in ans
            int cycle_size = 0;
            int j = i;
            while (!vis[j])
            {
                vis[j] = true;
                // move to next node
                j = arrpos.get(j).getValue();
                cycle_size++;
            }
            ans += (cycle_size - 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1,5,4,3,2};
        System.out.println(minSwaps(a));
    }
}
