package exer;

/**
 * author: cshuo
 * date: 2017/5/2
 * version: 1.0
 * description:
 */

enum EnumSingleTon{
    INSTANCE1(1),
    INSTANCE2(2),
    INSTANCE3(3);
    private int num;
    EnumSingleTon(int num){
        this.num = num;
    }
    public int getNum(){
        return num;
    }
}

public class EnumSingle {
    public static void main(String[] args) {
        System.out.println(EnumSingleTon.INSTANCE1.getNum());
        System.out.println(EnumSingleTon.INSTANCE2.getNum());
        System.out.println(EnumSingleTon.INSTANCE3.getNum());
    }
}
