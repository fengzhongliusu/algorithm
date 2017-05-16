package exer;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * author: cshuo
 * date: 2017/3/31
 * version: 1.0
 * description:
 */
interface A {
    void methodA();
}

abstract class B implements A{
}

class Parent{
    private int age;
    public int getAge(){
        return this.age;
    }
}

abstract class Child extends Parent{
    abstract void print();

    /**
     * @return
     * 可实现或者变为abstract
     */
    public abstract int getAge();
}

public class Main extends B{
    public static void main(String[] args) {
        String s = new String("asdf").intern();
        String s2 = "asdf";
        System.out.println(s == s2);
        Main m = new Main();
        Map<String ,Integer> a = new ConcurrentHashMap<>();
        Map<String, Integer> b = new HashMap<>();
        System.out.println(b.get("asdf"));
    }

    @Override
    public void methodA() {

    }
}
