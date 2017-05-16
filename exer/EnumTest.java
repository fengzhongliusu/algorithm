package exer;

/**
 * author: cshuo
 * date: 2017/4/11
 * version: 1.0
 * description:
 */
enum Calcu{
    PLUS,
    MINUS,
    TIMES,
    DIVIDE;
}
public class EnumTest {
    public static void main(String[] args) {
        Calcu c = Calcu.DIVIDE;
        switch (c){
            case DIVIDE:
                System.out.println("this is divide");
        }

    }
}
