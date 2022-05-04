package com.macrodream.javase.p01base.c03var;

/**
 * @author Macros.Zhang
 * @date 4/27/2022 17:38
 */
public class P04VarSpecialCase {
    public static void main(String[] args) {
        /*过大整数*/
        long l = 123213;
        System.out.println(l);

        /*编译错误 integer number too large: 21332423235234123*/
        /*long l1 = 21332423235234123;*/
        long l1 = 21332423235234123L;
        System.out.println(l1);

        /*编译错误 incompatible types: possible lossy conversion from double to float*/
        /*float f1 = 12.3;*/
        float f1 = 12.3F;
        float f2 = (float)12.3;
        System.out.println(f1);
        System.out.println(f2);

        /*
        整型常量默认int
        浮点型常量默认double
        */
        byte b = 12;

        /*编译错误incompatible types: possible lossy conversion from int to byte*/
        /*byte b1 = b + 1;*/

        /*编译错误incompatible types: possible lossy conversion from double to float*/
        /*float f3 = b + 12.3;*/

    }
}
