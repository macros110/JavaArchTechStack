package com.macrodream.javase.p01base.c03var;

/**
 * @author Macros.Zhang
 * @date 4/28/2022 07:52
 *
 *  字符串类型String
 *      非基本数据类型，属于引用数据类型
 *      使用方式与基本数据类型一致，String str = "abcd";
 *      多个字符串可以串接，String也可串接其他类型数据,连接运算 +
 *          str = str + "xyz"
 *          int n = 100;
 *          str = str + n;
 */
public class P05String {
    public static void main(String[] args) {
        String s1 = "Hello World!";

        System.out.println(s1);

        String s2 = "a";
        String s3 = "";

        /*编译错误 empty character literal*/
        /*char c = '';*/

        int number = 1001;
        String numberStr = "学号：";
        /*+ 连接运算*/
        String info = numberStr + number;
        boolean b1 = true;
        String info1 = info + b1;
        System.out.println(info1);

        char c = 'a';
        int num = 10;
        String str = "hello";
        /*107hello*/
        System.out.println(c + num + str);
        /*ahello10*/
        System.out.println(c + str + num);
        /*a10hello*/
        System.out.println(c + (num + str));
        /*107hello*/
        System.out.println((c + num) + str);
        /*hello10a*/
        System.out.println(str + num + c);

        /*
        *   *
        */
        /*V*/
        System.out.println("*   *");
        /*X*/
        System.out.println('*' + '\t' + '*');
        /*V*/
        System.out.println('*' + "\t" + '*');
        /*X*/
        System.out.println('*' + '\t' + "*");
        /*V*/
        System.out.println('*' + ('\t' + "*"));

        /*练习*/
        /*编译错误incompatible types: int cannot be converted to java.lang.String*/
        /*String str1 = 4;*/
        String str1 = 4 + "";

        /* 编译错误
        int num1 = str1;
        int num2 = (int)str1;
         */
        int num3 = Integer.parseInt(str1);
        System.out.println(num3);

    }
}
