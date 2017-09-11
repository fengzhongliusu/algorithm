package exer;


import java.util.*;

/**
 * author: cshuo
 * date: 2017/6/15
 * version: 1.0
 * description:
 */

class ClassA {
    static {
        System.out.println("A: static print");
    }
    {
        System.out.println("A: print");
    }
    public ClassA() {
        System.out.println("A: construct");
    }
}

class ClassB extends ClassA {
    static {
        System.out.println("B: static print");
    }
    {
        System.out.println("B: print");
    }
    public ClassB() {
        System.out.println("B: construct");
    }
}
public class Exercise {
    public static void main(String[] args) {
        new ClassB();
    }
}
