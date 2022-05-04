package com.macrodream.javase.p01base.c03var;

/**
 * @author Macros.Zhang
 * @date 4/26/2022 18:07
 *
 *  基本数据类型转换
 *      自动类型转换
 *          容量小自动转换容量大  byte|char|short>>int>>long>>float>>double
 *          多种数据类型混合运算，自动转成最大容量数据类型，然后进行计算
 *          byte，short，char之间不会相互转换，计算时首先转成int类型
 *          boolean不能与其他类型运算
 *          任何基本数据类型和String进行连接运算(+),基本数据类型的值都将自动转成String类型
 *      强制类型转换
 *          自动类型提升运算的逆运算,容量大>>容量小，运算符(),可能精度降低或溢出
 *          String不能直接转基本类型，可以通过包装类(Byte,Character,Short,Integer,Long,Float,Double,Boolean) 实现
 *              String a = "43";int i = Integer.parseInt(a);
 *          boolean类型不可转其他类型
 */
public class P03VarPromoteCast {
    public static void main(String[] args) {

        byte b1 = 2;
        int i1 = 129;
        /*编译错误incompatible types: possible lossy conversion from int to byte*/
        /*byte b2 = b1 + i1;*/

        int i2 = b1 + i1;
        long l1 = b1 + i1;
        System.out.println(i2);

        float f = b1 + i1;
        System.out.println(f);

        short s1 = 123;
        double d1 = s1;
        System.out.println(d1);

        /*97*/
        char c1 = 'a';
        int i3 = 10;
        int i4 = c1 + i3;
        System.out.println(i4);

        short s2 = 10;
        /*编译错误incompatible types: possible lossy conversion from int to char*/
        /*char c2 = c1 + s2;*/

        byte b2 = 10;
        /*编译错误incompatible types: possible lossy conversion from int to char*/
        /*char c3 = c1 + b2;*/

        /*编译错误incompatible types: possible lossy conversion from int to short*/
        /*short s3 = b2 + s2;*/
        /*编译错误incompatible types: possible lossy conversion from int to short*/
        /*short s4 = b1 + b2;*/


        /*强转*/
        double db1 = 12.9;
        /*截断操作*/
        int in1 = (int)db1;
        System.out.println(in1);

        /*无精度损失*/
        long lg1 = 123;
        short sh1 = (short)lg1;

        /*精度损失*/
        int in2 = 128;
        byte bt1 = (byte) in2;
        /*-128*/
        System.out.println(bt1);
    }
}
