package com.macrodream.javase.p01base.c04operator;

/**
 * @author Macros.Zhang
 * @date 4/28/2022 20:33
 *
 *  算术运算符
 *     运算符         运算          范例          结果
 *     +              正号           +3          3
 *     -              负号           b=4;-b      -4
 *     +               加           5+5          10
 *     -               减           6-4          2
 *     *               乘           3*4          12
 *     /               除           5/5          1
 *     %             取模(取余)      7%5          2
 *     ++    自增(前)，先运算后取值   a=2;b=++a;   a=3;b=3
 *     ++    自增(后)，先取值后运算   a=2;b=a++;   a=3;b=2
 *     --    自减(前)，先运算后取值   a=2;b=--a;   a=1;b=1
 *     --    自减(后)，先取值后运算   a=2;b=a--;   a=1;b=2
 *     +           字符串连接        "He"+"llo"   "Hello"
 */
public class P02ArithmeticOperator {
    public static void main(String[] args) {
        /* 除号 / */
        int num1 = 12;
        int num2 = 5;
        int result1 = num1 / num2;
        System.out.println(result1);

        int result2 = num1 / num2 * num2;
        System.out.println(result2);

        double result3 = num1 / num2;
        System.out.println(result3);

        double result4 = num1 / num2 + 0.0;
        double result5 = num1 / (num2 + 0.0);
        double result6 = (double) num1 / num2;
        double result7 = (double) (num1 / num2);
        System.out.println(result5);
        System.out.println(result6);

        /* % 取余运算
        *  结果的符号与北模数的符号相同
        *  开发中，经常使用%来判断能否被除尽的情况
        */
        int m1 = 12;
        int n1 = 5;
        System.out.println("m1 % n1 = " + m1 % n1);

        int m2 = -12;
        int n2 = 5;
        System.out.println("m2 % n2 = " + m2 % n2);

        int m3 = 12;
        int n3 = -5;
        System.out.println("m3 % n3 = " + m3 % n3);

        int m4 = -12;
        int n4 = -5;
        System.out.println("m4 % n4 = " + m4 % n4);

        /**
         * (前)++ 先自增1，后运算
         * (后)++ 先运算，后自增1
         */
        int a1 = 10;
        int b1 = ++a1;
        System.out.println("a1 = " + a1 + ",b1 = " + b1);

        int a2 = 10;
        int b2 = a2++;
        System.out.println("a2 = " + a1 + ",b2 = " + b1);

        int a3 = 10;
        ++a3; //a3++;
        int b3 = a3;

        /**
         * 注意点
         */
        short s1 = 10;
        /*incompatible types: possible lossy conversion from int to short*/
        /*s1 = s1 + 1;*/
        s1 = (short) (s1 + 1);
        /*自增1不会改变本身变量的数据类型*/
        s1++;
        System.out.println(s1);
        /**
         * 判断类型 基本类型没办法判断
         * instanceof
         * Class.isInstance
         * Class.isAssignFrom
         */
        System.out.println(short.class.isInstance(s1));

        /**
         * 问题：
         */
        byte bb1 = 127;
        bb1++;
        System.out.println("bb1 = " + bb1);

        /**
         * (前)-- 先自减1，后运算
         * (后)-- 先运算，后自减1
         */
        int a4 = 10;
        int b4 = a4--;
        int b5 = --a4;
        System.out.println("a4 = " + a4 + ", b4 = " + b4 + ", b5 = " + b5);




    }
}
