package exam;

/**
 * author: cshuo
 * date: 2017/4/6
 * version: 1.0
 * description:
 */
import java.util.Scanner;

public class JDAWS01  {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            char[][] game = new char[3][3];
            int nX = 0, n0 = 0;
            for (int i = 0; i < 3; i++) {
                String input = in.next();
                for (int j = 0; j < 3; j++) {
                    game[i][j] = input.charAt(j);
                    if (input.charAt(j) == 'X') {
                        nX++;
                    } else if (input.charAt(j) == '0') {
                        n0++;
                    }
                }
            }
            int diff = nX - n0;
            if (diff != 1 && diff != 0) {
                System.out.println("x");
                continue;
            }
            boolean wX = false, w0 = false;
            for (int i = 0; i < 3; i++) {
                if (game[i][1] != '.' && game[i][0] == game[i][1]
                        && game[i][1] == game[i][2]) {
                    if (game[i][1] == 'X') {

                        wX = true;
                    } else {
                        w0 = true;
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                if (game[1][i] != '.' && game[0][i] == game[1][i]
                        && game[1][i] == game[2][i]) {
                    if (game[1][i] == 'X') {
                        wX = true;
                    } else {
                        w0 = true;
                    }
                }
            }
            if (game[1][1] != '.'
                    && (game[0][0] == game[1][1] && game[1][1] == game[2][2])
                    || (game[0][2] == game[1][1] && game[1][1] == game[2][0])) {
                if (game[1][1] == 'X') {
                    wX = true;
                } else {
                    w0 = true;
                }
            }

            if (wX && w0 || wX && diff == 0 || w0 && diff == 1) {
                System.out.println("x");
            } else if (wX) {
                System.out.println("1 won");
            } else if (w0) {
                System.out.println("2 won");
            } else if (nX + n0 == 9) {
                System.out.println("draw");
            } else if (diff == 0) {
                System.out.println("1");
            } else if (diff == 1) {
                System.out.println("2");
            }
        }//while
        in.close();
    }
}
