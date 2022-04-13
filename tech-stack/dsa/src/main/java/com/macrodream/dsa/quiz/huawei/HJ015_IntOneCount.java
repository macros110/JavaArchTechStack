package com.macrodream.dsa.quiz.huawei;

import java.util.Scanner;

/**
 * @author Macros.Zhang
 * @date 4/6/2022 09:25
 * HJ15 求int型正整数在内存中存储时1的个数
 * 题目
 * 题解(327)
 * 讨论(1k)
 * 排行
 * 简单  通过率：57.25%  时间限制：1秒  空间限制：32M
 * 知识点
 * 位运算
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
 *
 * 数据范围：保证在 32 位整型数字范围内
 * 输入描述：
 *  输入一个整数（int类型）
 *
 * 输出描述：
 *  这个数转换成2进制后，输出1的个数
 *
 * 示例1
 * 输入：
 * 5
 * 复制
 * 输出：
 * 2
 * 复制
 * 示例2
 * 输入：
 * 0
 * 复制
 * 输出：
 * 0
 */
public class HJ015_IntOneCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = 0;
        /*bits*/
        int b = 32;
        for (int i = 0; i < b; i++) {
            if (1 == (n & 1)) {
                c++;
            }
            /*
             * >>表示右移，如果该数为正，则高位补0，若为负数，则高位补1；
             * >>>表示无符号右移，也叫逻辑右移，即若该数为正，则高位补0，
             * 而若该数为负数，则右移后高位同样补0。
             */
            n = n >>> 1;
        }
        System.out.println(c);
    }
}
