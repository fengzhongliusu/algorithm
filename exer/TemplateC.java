package exer;

import java.util.HashMap;

/**
 * author: cshuo
 * date: 2017/4/26
 * version: 1.0
 * description:
 */
public class TemplateC<T> {
    public T get(T value){
        return value;
    }

    public static void main(String[] args) {
        TemplateC<Integer> t = new TemplateC<>();
        System.out.println(t.get(1));
        HashMap<String, Integer> v = new HashMap();
        v.put("adsf",1);
        System.out.println(v.containsKey("adsf"));
        System.out.println(v.containsValue(1));


    }
}
