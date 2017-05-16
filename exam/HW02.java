package exam;
import java.util.Scanner;
/**
 * author: cshuo
 * date: 2017/4/20
 * version: 1.0
 * description:
 */


class item {

    public int id;
    public int priority;
    public int startTime;
    public int totalTime;

    item(int id, int priority, int startTime, int totalTime) {
        this.id = id;
        this.priority = priority;
        this.startTime = startTime;
        this.totalTime = totalTime;

    }
}

public class HW02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        item[] items = new item[5];
        for (int i = 0; i < 5; i++) {
            items[i] = new item(0, 0, 0, 0);
        }

        String str = in.next();

        String[] arr = str.split("\\|");
        int minStartTime = 0;
        for (int i = 0; i < arr.length; i++) {
            String[] temp = arr[i].substring(1, arr[i].length() - 1).split("\\.");
            int id = Integer.parseInt(temp[0]);
            int priority = Integer.parseInt(temp[1]);
            int startTime = Integer.parseInt(temp[2]);
            int totalTime = Integer.parseInt(temp[3]);
            items[i].id = id;
            items[i].priority = priority;
            items[i].startTime = startTime;
            items[i].totalTime = totalTime;
        }

        int[] times = new int[201];
        for (int i = 0; i < 201; i++) {
            times[i] = 0;
        }
        int i;
        for (i = 0; i < 201; i++) {
            int max = -1;
            int pos = -1;
            boolean flag = false;
            for (int j = 0; j < 5; j++) {
                if (items[j].totalTime > 0) {
                    flag = true;
                }
                if (items[j].totalTime > 0 && items[j].startTime <= i && items[j].priority > max) {
                    max = items[j].priority;
                    pos = j;
                }
            }
            if (!flag) {
                break;
            }
            if (max != -1) {
                times[i] = items[pos].id;
                items[pos].totalTime--;
            }
        }
        int maxTime = i;
        int curItem = times[0];
        int count = 0;
        for(i=0;i<200;i++){
            if(times[i] == curItem){
                count++;
            }
            else{
                System.out.printf("%d.%d|",curItem,count);
                curItem = times[i];
                count = 1;
            }
        }
        System.out.printf("%d.%d",curItem,count);

    }

}

