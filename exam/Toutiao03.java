package exam;

import java.util.Scanner;

/**
 * author: cshuo
 * date: 2017/4/18
 * version: 1.0
 * description:
 */
public class Toutiao03 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] rt;

        int[][][] numPics = {
                {{1,1,1},{1,0,1},{1,0,1},{1,0,1},{1,1,1}},
                {{1,0,0},{1,0,0},{1,0,0},{1,0,0},{1,0,0}},
                {{1,1,1},{0,0,1},{1,1,1},{1,0,0},{1,1,1}},
                {{1,1,1},{0,0,1},{1,1,1},{0,0,1},{1,1,1}},
                {{1,0,1},{1,0,1},{1,1,1},{0,0,1},{0,0,1}},
                {{1,1,1},{1,0,0},{1,1,1},{0,0,1},{1,1,1}},
                {{1,1,1},{1,0,0},{1,1,1},{1,0,1},{1,1,1}},
                {{1,1,1},{0,0,1},{0,0,1},{0,0,1},{0,0,1}},
                {{1,1,1},{1,0,1},{1,1,1},{1,0,1},{1,1,1}},
                {{1,1,1},{1,0,1},{1,1,1},{0,0,1},{1,1,1}}
        };

        int[][][] opPics = {
                {{0,0,0},{0,1,0},{1,1,1},{0,1,0},{0,0,0}},
                {{0,0,0},{0,0,0},{1,1,1},{0,0,0},{0,0,0}},
                {{0,0,0},{1,0,1},{0,1,0},{1,0,1},{0,0,0}},
                {{0,0,0},{0,0,1},{0,1,0},{1,0,0},{0,0,0}},
                {{0,0,0,0},{1,1,1,1},{0,0,0,0},{1,1,1,1},{0,0,0,0}},
                {{0,0,0},{0,0,0},{0,0,0},{1,1,0},{1,1,0}},
        };

        int colSign = 0;
        int charInt;
        while(in.hasNext()){
            String exp = in.next();
            rt = getRes(exp);
            int[][] rsMt = new int[5][100];

            //输出第一个数字
            for(int i=0; i<rt[0].length(); i++){
                charInt = rt[0].charAt(i) - '0';
                if(charInt != 1){
                    for(int j = colSign; j<colSign+3; j++)
                        for(int k=0; k<5; k++)
                            rsMt[k][j] = numPics[charInt][k][j-colSign];
                    colSign += 5;
                } else {
                    for(int k=0; k<5; k++)
                        rsMt[k][colSign] = numPics[charInt][k][0];
                    colSign += 3;
                }
            }

            //操作符号
            int opsIndex = 0;
            if(rt[2].equals("+")) opsIndex = 0;
            else if(rt[2].equals("-")) opsIndex = 1;
            else if(rt[2].equals("*")) opsIndex = 2;
            else opsIndex = 3;

            //输出操作符号
            for(int j=colSign; j<colSign+3; j++)
                for(int k=0; k<5; k++)
                    rsMt[k][j] = opPics[opsIndex][k][j-colSign];
            colSign += 5;

            //输出第二个数字
            for(int i=0; i<rt[1].length(); i++){
                charInt = rt[1].charAt(i) - '0';
                if(charInt != 1){
                    for(int j = colSign; j<colSign+3; j++)
                        for(int k=0; k<5; k++)
                            rsMt[k][j] = numPics[charInt][k][j-colSign];
                    colSign += 5;
                } else {
                    for(int k=0; k<5; k++)
                        rsMt[k][colSign] = numPics[charInt][k][0];
                    colSign += 3;
                }
            }

            //输出等号
            for(int j=colSign; j<colSign+4; j++)
                for(int k=0; k<5; k++)
                    rsMt[k][j] = opPics[4][k][j-colSign];
            colSign += 6;

            //输出算式结果
            for(int i=0; i<rt[3].length(); i++){
                if(rt[3].charAt(i) == '.'){
                    for(int j = colSign; j<colSign + 2; j++){
                        for(int k=0; k<5; k++){
                            rsMt[k][j] = opPics[5][k][j-colSign];
                        }
                    }
                    colSign += 4;
                } else if(rt[3].charAt(i) == '-'){
                    for(int j=colSign; j<colSign+3; j++)
                        for(int k=0; k<5; k++)
                            rsMt[k][j] = opPics[1][k][j-colSign];
                    colSign += 5;
                } else {
                    charInt = rt[3].charAt(i) - '0';
                    if(charInt != 1){
                        for(int j = colSign; j<colSign+3; j++)
                            for(int k=0; k<5; k++)
                                rsMt[k][j] = numPics[charInt][k][j-colSign];
                        colSign += 5;
                    } else {
                        for(int k=0; k<5; k++)
                            rsMt[k][colSign] = numPics[charInt][k][0];
                        colSign += 3;
                    }
                }
            }

            printMt(rsMt,colSign);
            colSign = 0;
        }

        in.close();
    }

    public static void printMt(int[][] maps, int col){
        for(int i=0; i< 5; i++){
            for(int j=0; j<col-2; j++){
                if(maps[i][j] == 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static String[] getRes(String s){
        String[] ops;
        String rs;
        String []rt = new String[4];
        int intRs;
        double tmpRs;
        if(s.contains("+")){
            rt[2] = "+";
            ops = s.split("\\+");
            rs = Integer.toString(Integer.parseInt(ops[0]) + Integer.parseInt(ops[1]));
        } else if(s.contains("-")){
            rt[2] = "-";
            ops = s.split("-");
            rs = Integer.toString(Integer.parseInt(ops[0]) - Integer.parseInt(ops[1]));
        } else if(s.contains("*")){
            rt[2] = "*";
            ops = s.split("\\*");
            rs = Integer.toString(Integer.parseInt(ops[0]) * Integer.parseInt(ops[1]));
        } else {
            rt[2] = "/";
            ops = s.split("/");
            tmpRs = (double)Integer.parseInt(ops[0]) / Integer.parseInt(ops[1]);
            tmpRs = Double.valueOf(String.format("%.2f", tmpRs));
            intRs = Integer.parseInt(ops[0]) / Integer.parseInt(ops[1]);
            rs = tmpRs > intRs? Double.toString(tmpRs):Integer.toString(intRs);
        }

        rt[0] = ops[0];
        rt[1] = ops[1];
        rt[3] = rs;
        return rt;
    }
}
