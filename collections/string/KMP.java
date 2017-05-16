package collections.string;

/**
 * test
 */
public class KMP {
    public static void main(String[] args) {
        String p = "asdf";
        String text = "dfkdfkdfjasdfwoewpewasdfpasdodododooddddddddddddddkllllllllllllaaaaaaaaaaaaasdfiiiiiiiiiiiiiiiiieeeeeeeeeeeeeefhhhhh";
        int []next = KMP.calNext(p);
        KMP.search(p, text, next);
    }

    public static int[] calNext(String p){
        int []next = new int[p.length()+1];
        next[0] = 0;
        next[1] = 0;
        int j = 0;
        for(int i=1; i<p.length(); i++){
            while(j>0 && p.charAt(i) != p.charAt(j)) j=next[j];
            if(p.charAt(i) == p.charAt(j)) j++;
            next[i+1] = j;
        }
        return next;
    }

    public static void search(String p, String text, int[] next){
        int j = 0;
        for(int i=0; i<text.length(); i++){
            while(j>0 && p.charAt(j) != text.charAt(i)) j=next[j];
            if(text.charAt(i) == p.charAt(j)) j++;
            if(j == p.length()){
                System.out.println("find pattern:" + text.substring(i-p.length()+1,i+1));
                j = next[j];
            }
        }
    }
}
