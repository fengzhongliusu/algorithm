import java.util.*;

class Main{
    public String PrintMinNumber(int [] numbers) {
        List<Integer> lists = new ArrayList<Integer>();
        for(int e: numbers) {
            lists.add(e);
        }

        Collections.sort(lists, new Comparator<Integer>(){
            public int compare(Integer str1, Integer str2){
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int s: lists){
            sb.append(s);
        }
        return sb.toString();
    }
}
