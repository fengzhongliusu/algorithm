package exam;

/**
 * author: cshuo
 * date: 2017/4/26
 * version: 1.0
 * description:
 */
public class Yinzi{
    private static Yinzi m_t;

    public void assign(Yinzi t)
    {
        m_t = t;
    }

    public void clear(Yinzi t)
    {
        t = null;
    }

    public static void main(String[] args) {
        Yinzi t1 = new Yinzi();
        Yinzi t2 = new Yinzi();
        Yinzi t3 = new Yinzi();

        t1.assign(t2);
        t1 = null;
        t2 = null;
        t3.clear(t3);
        System.out.println(t3 == null);
        System.out.println(t2 == null);

        System.out.println("This point");
    }
}
