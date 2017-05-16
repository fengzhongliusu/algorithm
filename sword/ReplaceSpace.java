package sword;

/**
 * author: cshuo
 * date: 2017/5/1
 * version: 1.0
 * description:
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        System.out.println(replaceSpace("hello world"));
    }

    public static String replaceSpace(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) != ' ') sb.append(str.charAt(i));
            else sb.append("%20");
        }
        return sb.toString();
    }
}
