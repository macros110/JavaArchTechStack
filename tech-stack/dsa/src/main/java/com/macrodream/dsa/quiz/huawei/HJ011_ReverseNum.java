package com.macrodream.dsa.quiz.huawei;

import java.util.Scanner;

/**
 * @author Macros.Zhang
 * @date 4/5/2022 22:09
 *
 *
HJ11 数字颠倒
题目
题解(256)
讨论(1k)
排行
简单  通过率：58.66%  时间限制：1秒  空间限制：32M
知识点
字符串
warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
描述
输入一个整数，将这个整数以字符串的形式逆序输出
程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001


数据范围： 0 \le n \le 2^{30}-1 \ 0≤n≤2
30
−1
输入描述：
输入一个int整数

输出描述：
将这个整数以字符串的形式逆序输出

示例1
输入：
1516000
复制
输出：
0006151
复制
示例2
输入：
0
复制
输出：
0

 */
public class HJ011_ReverseNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(reverseNum(num));
    }

    private static String reverseNum(int num) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(num % 10);
            num /= 10;
        } while (num != 0);
        return sb.toString();
    }
}
