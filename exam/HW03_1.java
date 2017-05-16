package exam;

/**
 * author: cshuo
 * date: 2017/4/20
 * version: 1.0
 * description:
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class HW03_1{
    static Long iptoNum(String ip) {
        Scanner sc = new Scanner(ip).useDelimiter("\\.");
        return(sc.nextLong() << 24) +
                (sc.nextLong() << 16) +
                (sc.nextLong() << 8) +
                (sc.nextLong());
    }
    public static void main(String[] args)  {
        Comparator<String> ipComp = new Comparator<String>() {
            @Override public int compare(String ip1, String ip2) {
                return iptoNum(ip1).compareTo(iptoNum(ip2));
            }
        };

        Scanner in = new Scanner(System.in);
//        Scanner in = new Scanner(new File("D://a.txt"));
        String[] str_list= new String[100];
        ArrayList<String> a_list = new ArrayList<>();
        ArrayList<String> b_list = new ArrayList<>();
        ArrayList<String> c_list = new ArrayList<>();
        ArrayList<String> d_list = new ArrayList<>();
        ArrayList<String> e_list = new ArrayList<>();

        int index = 0;
        for (int k = 0; k < 5; k++) {
            String addr= in.nextLine();
            String nums[] = addr.split("\\.");
            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                long num = Long.parseLong(nums[i]);
                if(num>255) flag = true;
            }
            if (flag) continue;
            int addr_high=Integer.parseInt(nums[0]);
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
        Collections.sort(a_list,ipComp);
        Collections.sort(b_list,ipComp);
        Collections.sort(c_list,ipComp);
        Collections.sort(d_list,ipComp);
        Collections.sort(e_list,ipComp);

        if(!a_list.isEmpty()) {
            System.out.print("A:");
            printIp(a_list);
        }
        if(!b_list.isEmpty()) {
            System.out.print("B:");
            printIp(b_list);
        }
        if(!c_list.isEmpty()) {
            System.out.print("C:");
            printIp(c_list);
        }
        if(!d_list.isEmpty()) {
            System.out.print("D:");
            printIp(d_list);
        }
        if(!e_list.isEmpty()){
            System.out.print("E:");
            printIp(e_list);
        }
    }

    public static void printIp(ArrayList<String> ips){
        System.out.print("[");
        for(int i=0; i<ips.size(); i++){
            System.out.print(ips.get(i));
            if(i < ips.size()-1) System.out.print(",");
        }
        System.out.println("]");

    }


}

