package exam;

import java.util.Scanner;

public class JD01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numX, numO;
        String tmp;
        while(in.hasNext()){
            numO = 0;
            numX = 0;
            boolean winO=false, winX=false, full = true;
            char[][] clist=  new char[3][3];
            for(int i=0; i<3; i++){
                tmp = in.next();
                for(int j=0; j<3; j++){
                    clist[i][j] = tmp.charAt(j);
                    if(clist[i][j] == '0') numO ++;
                    else if(clist[i][j] == 'X') numX ++;
                    else full = false;
                }
            }

            int diff = numX - numO;
            if(numO > numX || numX - numO > 1){
                System.out.println('x');
                continue;
            }


            for(int i=0; i<3; i++){
                if(clist[i][0] == clist[i][1] && clist[i][1] == clist[i][2]){
                    if(clist[i][0] == '0') winO = true;
                    else if(clist[i][0] == 'X') winX = true;
                }
            }

            for(int i=0; i<3; i++){
                if(clist[0][i] == clist[1][i] && clist[1][i] == clist[2][i]){
                    if(clist[0][i] == '0') winO = true;
                    else if(clist[0][i] == 'X') winX = true;
                }
            }

            if(clist[0][0] == clist[1][1] && clist[1][1] == clist[2][2]){
                if(clist[0][0] == '0') winO = true;
                else if(clist[0][0] == 'X') winX = true;
            }

            if(clist[0][2] == clist[1][1] && clist[1][1] == clist[2][0]){
                if(clist[0][2] == '0') winO = true;
                else if(clist[0][2] == 'X') winX = true;
            }

            if(winO && winX || winX && diff == 0 || winO && diff == 1) System.out.println('x');
            else if(winO) System.out.println("2 won");
            else if(winX) System.out.println("1 won");
            else if(full) System.out.println("draw");
            else if(numX == numO) System.out.println("1");
            else System.out.println("2");
        }
    }
}
