package exam;

/**
 * author: cshuo
 * date: 2017/4/20
 * version: 1.0
 * description:
 */
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class HW03{
    static Long toNumeric(String ip) {
        Scanner sc = new Scanner(ip).useDelimiter("\\.");
        return(sc.nextLong() << 24) +
                (sc.nextLong() << 16) +
                (sc.nextLong() << 8) +
                (sc.nextLong());
    }
    public static void main(String[] args) throws FileNotFoundException {
        Comparator<String> ipComparator = new Comparator<String>() {
            @Override public int compare(String ip1, String ip2) {
                return toNumeric(ip1).compareTo(toNumeric(ip2));
            }
        };

        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            String[] str_list= new String[100];
            ArrayList<String> a_list = new ArrayList<String>();
            ArrayList<String> b_list = new ArrayList<String>();
            ArrayList<String> c_list = new ArrayList<String>();
            ArrayList<String> d_list = new ArrayList<String>();
            ArrayList<String> e_list = new ArrayList<String>();

            int index = 0;
            while(index++ < 5){
                String addr= in.next();
                String nums[] = addr.split("\\.");
                int addr_high=Integer.parseInt(nums[0]);
                if (addr_high > 255) continue;
                if((addr_high & 0x80) == 0){
                    a_list.add(addr);
                }else if ((addr_high & 0xC0) == 0x80){
                    b_list.add(addr);
                }else if ((addr_high & 0xE0) == 0xC0){
                    c_list.add(addr);
                }else if ((addr_high & 0xF0) == 0xE0){
                    d_list.add(addr);
                }else if ((addr_high & 0xF8) == 0xF0){
                    e_list.add(addr);
                }
            }
            Collections.sort(a_list,ipComparator);
            Collections.sort(b_list,ipComparator);
            Collections.sort(c_list,ipComparator);
            Collections.sort(d_list,ipComparator);
            Collections.sort(e_list,ipComparator);

            if(a_list.isEmpty() == false) {
                System.out.print("A:");
                System.out.println(a_list);
            }
            if(b_list.isEmpty() == false) {
                System.out.print("B:");
                System.out.println(b_list);
            }
            if(c_list.isEmpty() == false) {
                System.out.print("C:");
                System.out.println(c_list);
            }
            if(d_list.isEmpty() == false) {
                System.out.print("D:");
                System.out.println(d_list);
            }
            if(e_list.isEmpty() == false){
                System.out.print("E:");
                System.out.println(e_list);
            }
        }
    }


}

