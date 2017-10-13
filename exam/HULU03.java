package exam;

import java.util.Scanner;

public class HULU03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            int[][] mtx = new int[n][n];
            int countB = 0, countW = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    int num = in.nextInt();
                    if(num == 1) countB++;
                    else if(num == 2) countW++;
                    mtx[i][j] = num;
                }
            }
            if(countB != countW) {
                System.out.println(-1);
                continue;
            }
            bwin(mtx, mtx.length);
        }
        in.close();
    }

    public static void bwin(int[][] mtx, int n) {
        boolean b=false, w = false;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(mtx[i][j]==0) continue;
                if(j+3<n) {
                    if(mtx[i][j] == 1) {
                        boolean Ok = true;
                        for(int k=j+1; k<=j+3; k++)
                            if(mtx[i][k] != 1) { Ok=false; break;}
                        if(Ok) {
                            if(j-1 >= 0 && mtx[i][j-1] == 0 || j+4 < n && mtx[i][j+4] == 0){
                                System.out.println(1);
                                return;
                            }
                        }
                    } else {
                        boolean Ok = true;
                        for(int k=j+1; k<=j+3; k++)
                            if(mtx[i][k] != 2) { Ok=false; break;}
                        if(Ok) {
                            if(j-1 >= 0 && mtx[i][j-1] == 0 && j+4 < n && mtx[i][j+4] == 0) w = true;
                        }
                    }
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(mtx[j][i] == 0) continue;
                if(j+3 < n) {
                    if(mtx[i][j] == 1) {
                        boolean ok = true;
                        for(int k = j+1; k<= j+3; k++) if(mtx[k][i] != 1) {ok = false; j=k; break;}
                        if(ok) {
                            if(j-1 >= 0 && mtx[j-1][i] == 0 || j+4 < 0 && mtx[j+4][i] == 0) {
                                System.out.println(1);
                                return;
                            }
                        }
                    } else {
                        boolean ok = true;
                        for(int k = j+1; k<= j+3; k++) if(mtx[k][i] != 2) {ok = false; j=k; break;}
                        if(ok) {
                            if(j-1 >= 0 && mtx[j-1][i] == 0 && j+4 < 0 && mtx[j+4][i] == 0) w = true;
                        }
                    }
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i+3 >=n || j+3 >= n) continue;
                if(mtx[i][j] == 0) continue;
                if(mtx[i][j] == 1) {
                    boolean ok = true;
                    for(int k=1; k<4; k++) if(mtx[i+k][j+k] != 1) {ok=false; break;}
                    if(ok) {
                        if(i-1 >=0 && j-1 >= 0 && mtx[i-1][j-1] == 0 || i+4 < n && j+4 < n && mtx[i+4][j+4] == 0) {
                            System.out.println(1);
                            return;
                        }
                    }
                } else {
                    boolean ok = true;
                    for(int k=1; k<4; k++) if(mtx[i+k][j+k] != 2) {ok=false; break;}
                    if(ok) {
                        if(i-1 >=0 && j-1 >= 0 && mtx[i-1][j-1] == 0 && i+4 < n && j+4 < n && mtx[i+4][j+4] == 0) w=true;
                    }
                }
            }
        }
        if (w==true) System.out.println(2);
        else System.out.println(0);
    }

//    public static boolean wwin(int[][] mtx, int n) {
//        for(int i=0; i<n; i++) {
//            for(int j=0; j<n; j++) {
//                if(mtx[i][j] == 1 || mtx[i][j]==0) continue;
//                if(j+3<n) {
//                    boolean Ok = true;
//                    for(int k=j+1; k<=j+3; k++)
//                        if(mtx[i][k] != 2) { Ok=false; break;}
//                    if(Ok) {
//                        if(j-1 >= 0 && mtx[i][j-1] == 0 && j+4 < n && mtx[i][j+4] == 0) return true;
//                    }
//                }
//            }
//        }
//        for(int i=0; i<n; i++) {
//            for(int j=0; j<n; j++) {
//                if(mtx[j][i] == 1 || mtx[j][i] == 0) continue;
//                if(j+3 < n) {
//                    boolean ok = true;
//                    for(int k = j+1; k<= j+3; k++) if(mtx[k][i] != 2) {ok = false; j=k; break;}
//                    if(ok) {
//                        if(j-1 >= 0 && mtx[j-1][i] == 0 && j+4 < 0 && mtx[j+4][i] == 0) return true;
//                    }
//                }
//            }
//        }
//        for(int i=0; i<n; i++) {
//            for(int j=0; j<n; j++) {
//                if(i+3 >=n || j+3 >= n) continue;
//                if(mtx[i][j] == 1 || mtx[i][j] == 0) continue;
//                if(mtx[i][j] == 2) {
//                    boolean ok = true;
//                    for(int k=1; k<4; k++) if(mtx[i+k][j+k] != 2) {ok=false; break;}
//                    if(ok) {
//                        if(i-1 >=0 && j-1 >= 0 && mtx[i-1][j-1] == 0 && i+4 < n && j+4 < n && mtx[i+4][j+4] == 0) return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
}
