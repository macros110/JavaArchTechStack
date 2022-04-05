package com.macrodream.dsa.quiz.huawei;

import java.util.Scanner;

/**
 * @author Macros.Zhang
 * @date 4/5/2022 12:05
 * HJ6 质数因子
 * 题目
 * 题解(365)
 * 讨论(1k)
 * 排行
 * 简单  通过率：27.05%  时间限制：1秒  空间限制：32M
 * 知识点
 * 排序
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 *
 *
 * 数据范围： 1 \le n \le 2 \times 10^{9} + 14 \ 1≤n≤2×10
 * 9
 *  +14
 * 输入描述：
 * 输入一个整数
 *
 * 输出描述：
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。
 *
 * 示例1
 * 输入：
 * 180
 * 复制
 * 输出：
 * 2 2 3 3 5
 */
public class HJ006_PrimeFacoterSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        printSortPrime(num);
    }

    private static void printSortPrime(long num) {
        /*质因子定律*/
        long f = (long) Math.sqrt(num);
        for (long i = 2; i <= f ; i++) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        System.out.println( num == 1 ? "" : num + " ");
    }
}