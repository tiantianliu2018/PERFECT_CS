package com.learn.chapter10;

import java.util.ArrayList;

/**
 * @author Kelly
 * @create 2021-05-05 10:35
 */
public class JavaCollection {
    public static void main(String[] args) {
//        不可变集合
        int[] nums = new int[3];
        nums[2] = 11;
        nums[2] = 20;
        nums[1] = 90;

        String[] names = {"Toms", "Jack"};
        System.out.println(nums + " " + names);

//      可变集合
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        System.out.println(list + " 地址 = " + list.hashCode());
        list.add("c");
        System.out.println(list + " 地址 = " + list.hashCode());
    }
}
