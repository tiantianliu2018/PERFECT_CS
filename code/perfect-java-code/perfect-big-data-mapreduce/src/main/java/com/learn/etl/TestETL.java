package com.learn.etl;

/**
 * @author Kelly
 * @create 2021-04-13 11:00
 */
public class TestETL {
    public static void main(String[] args) {
        String checkPhone = "^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$";
        String phone = "13568970326";
        System.out.println(phone.matches(checkPhone));
    }
}
