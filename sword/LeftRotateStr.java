package sword;

/**
 * Created by cshuo on 2017/7/23
 * 字符串循环左移操作。
 */
public class LeftRotateStr {
    /**
     * 注意n的取模.
     */
    public String LeftRotateString(String str,int n) {
        if(n <= 0 || str.length() < 1) return str;
        StringBuilder rs = new StringBuilder();
        n %= str.length();
        rs.append(str.substring(n)).append(str.substring(0,n));
        return rs.toString();
    }
}
