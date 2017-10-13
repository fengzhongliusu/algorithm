package exam;

import java.util.Scanner;

public class psvm {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int cases = in.nextInt();
            for(int c=0; c<cases; c++) {
                int m = in.nextInt();
                int n = in.nextInt();
                char[][] mtx = new char[m][n];
                for(int i=0; i<m; i++){
                    String tmp = in.next();
                    mtx[i] = tmp.toCharArray();
                }
                String target = in.next();
                System.out.println(count(mtx, m, n, target));
            }
        }
        in.close();
    }

    public static int count(char[][] mtx, int m, int n, String target) {
        int count =0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i+target.length() <= m) {
                    boolean ok = true;
                    for(int k=0; k<target.length(); k++) {
                        if(mtx[i+k][j] != target.charAt(k)) {ok=false; break;}
                    }
                    if(ok) count++;
                }
                if(j+target.length() <=n) {
                    boolean ok = true;
                    for(int k=0; k<target.length(); k++) {
                        if(mtx[i][j+k] != target.charAt(k)) {ok=false; break;}
                    }
                    if(ok) count++;
                }
                if(i+target.length() <=m && j+target.length()<=n) {
                    boolean ok = true;
                    for(int k=0; k<target.length(); k++) {
                        if(mtx[i+k][j+k] != target.charAt(k)) {ok=false; break;}
                    }
                    if(ok) count++;
                }
            }
        }


//        StringBuilder sb = new StringBuilder();
//        for(int i=0; i<m; i++) {
//            for(int j=0; j<m; j++) {
//                String s = new String(mtx[i], j, Math.min(n-j, len));
//                if(s.equals(target)) count++;
//                sb.setLength(0);
//                for(int k=i; k<i+Math.min(m-i, len); k++) sb.append(mtx[k][j]);
//                if(sb.toString().equals(target)) count++;
//                sb.setLength(0);
//                for(int p=i, q=j; p<i+Math.min(m-i, len) && q<j+Math.min(n-j, len); p++, q++) sb.append(mtx[p][q]);
//                if(sb.toString().equals(target)) count++;
//            }
//        }
        return count;
    }
}
