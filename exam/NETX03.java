package exam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class NETX03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int line = in.nextInt();
            String[] dates = new String[line];
            int[] flows = new int[line];
            for(int i=0; i<line; i++) {
                String s1 = in.next(), s2 = in.next();
                dates[i] = s1 + " "+ s2;
                flows[i] = in.nextInt();
            }

            int qNum = in.nextInt();
            for(int i=0; i<qNum; i++) {
                String s1 = in.next(), s2 = in.next(), e1 = in.next(), e2 = in.next();
                int idx1 = firstGreaterOrEqual(dates, s1 + " " + s2);
                if(idx1 == line) {
                    System.out.println(0);
                    continue;
                }
                int idx2 = firstGreaterOrEqual(dates, e1 + " " + e2);
                if(idx2 == line) idx2 = line-1;
                else if(getDate(dates[idx2]).compareTo(getDate(e1+" "+e2)) >0) idx2--;
                int sum = 0;
                for(int j=idx1; j<=idx2; j++) sum+=flows[j];
                System.out.println(sum);
            }
        }
        in.close();
    }

    public static int firstGreaterOrEqual(String[] nums, String target) {
        int l=0, r=nums.length, mid;
        while(l < r) {
            mid = (r-l)/2 + l;
            if(getDate(target).compareTo(getDate(nums[mid])) <=0) r = mid;
            else l = mid + 1;
        }
        return r;
    }


    public static Date getDate(String str) {
        Date s1 = null;
        try {
            s1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.CHINA).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(s1 == null) System.out.println("null");
        return s1;
    }
}
