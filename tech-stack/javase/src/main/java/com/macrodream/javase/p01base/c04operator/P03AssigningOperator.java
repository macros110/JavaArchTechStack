package com.macrodream.javase.p01base.c04operator;

/**
 * @author Macros.Zhang
 * @date 5/22/2022 20:47
 * 赋值运算符
 *  符合 =
 *      两侧数据类型不一致，可使用自动类型转换或使用强制类型转换原则进行处理
 *      支持连续赋值
 *  扩展赋值运算符 +=,-=,*=,/=,%=
 */
public class P03AssigningOperator {
    public static void main(String[] args) {
        /*=*/
        int i1 = 10;
        int j1 = 10;

        int i2,j2;
        /*连续赋值*/
        i2 = j2 = 10;

        int i3 = 10, j3 = 20;

        int num1 = 10;
        /*num1 = num1 + 2;*/
        num1 += 2;
        System.out.println(num1);

        int num2 = 12;
        /*num2 = num2 % 5;*/
        num2 %= 5;
        System.out.println(num2);

        short s1 = 10;
        /*编译失败incompatible types: possible lossy conversion from int to short*/
        /*s1 = s1 + 2;*/
        s1 += 2;
        /*不会改变变量本身的数据类型*/
        System.out.println(s1);

        /**
         * 开发中，实现变量+2操作方法 int num = 10;
         * 1 num = num + 2;
         * 2 num += 2;推荐
         *
         * 开发中，实现变量+1操作方法  int num = 10;
         * 1  num = num + 1
         * 2  num += 1;
         * 3  num++; 推荐
         */

        int i = 1;
        i *= 0.1;
        /*0*/
        System.out.println(i);
        i++;
        /*1*/
        System.out.println(i);

        int m = 2;
        int n = 3;
        /*n = n*m++; */
        n *= m++;
        /*3*/
        System.out.println("m=" + m);
        /*6*/
        System.out.println("n=" + n);

        int n1 = 10;
        /*n1 = n1 + (n1++) + (++n1)*/
        n1 += (n1++) + (++n1);
        /*32*/
        System.out.println(n1);
    }
}
