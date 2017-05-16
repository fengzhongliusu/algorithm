package sword;

/**
 * author: cshuo
 * date: 2017/5/1
 * version: 1.0
 * description:
 */
public class FindNumINMatrix {
    public static void main(String[] args) {

    }

    public static boolean find(int target, int[][] array){
        int row = array.length - 1, col = 0;
        while(row > -1 && col < array[0].length){
            if(target == array[row][col]) return true;
            else if(target > array[row][col]) col++;
            else row--;
        }
        return false;
    }
}
