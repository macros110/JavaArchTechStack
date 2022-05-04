package com.macrodream.javase.p01base.c03var;

/**
 * @author Macros.Zhang
 * @date 4/28/2022 12:35
 *
 *    进制
 *      所有数字在计算机底层都以二进制形式存在。
 *      整数，四种表示
 *          二进制(binary) 0,1 ,满2进1，以0b或0B开头
 *              整数常量默认int，第32为符号位；long，第64为符号位
 *              三种形式：
 *                  原码：直接将一个数值换成二进制数。最高位是符号位
 *                  负数的反码：对源码按位取反，最高位确定为1
 *                  负数的补码：反码加1
 *                  14>>0000 1110   -14>>1000 1110(原码)>>1111 0001(反)>>1111 0010(补)
 *              计算机以二进制补码的形式保存所有的整数。
 *                  正数的原码、反码、补码都相同
 *                  负数的补码是其反码+1
 *          十进制(decimal) 0-9,满10进1
 *          八进制(octal) 0-7,满8进1，以数字0开头表示
 *          十六进制(hex) 0-9A-F,满16进1，以0x或0X开头。A-F不区分大小写
 *              0x21AF + 1 = 0x21B0
 *
 */
public class P06HexBinDecOct {
    public static void main(String[] args) {
        int num1 = 0b110;
        int num2 = 110;
        int num3 = 0127;
        int num4 = 0x110A;

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("num3 = " + num3);
        System.out.println("num4 = " + num4);
    }
}
