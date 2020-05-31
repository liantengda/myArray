package com.lian.mycollection;



/**
 * @author Ted
 * @version 1.0
 * @date 2020/5/31 18:53
 */
public class Test {
    public static void main(String[] args) {
        String s1 = new String("123");
        String s2 = new String("123");
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
    }
}
