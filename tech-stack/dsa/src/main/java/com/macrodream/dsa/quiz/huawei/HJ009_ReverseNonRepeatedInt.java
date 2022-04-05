package com.macrodream.dsa.quiz.huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Macros.Zhang
 * @date 4/5/2022 21:17
 * HJ9 提取不重复的整数
 * 题目
 * 题解(428)
 * 讨论(1k)
 * 排行
 * 入门  通过率：44.46%  时间限制：1秒  空间限制：32M
 * 知识点
 * 数组
 * 哈希
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 *
 * 数据范围： 1 \le n \le 10^{8} \ 1≤n≤10
 * 8
 *
 * 输入描述：
 * 输入一个int型整数
 *
 * 输出描述：
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * 示例1
 * 输入：
 * 9876673
 * 复制
 * 输出：
 * 37689
 *
 */
public class HJ009_ReverseNonRepeatedInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        while(num != 0){
            int q = num % 10;
            num /= 10;
            if (set.contains(q)) {
                continue;
            }
            res = res * 10 + q;
            set.add(q);
        }
        System.out.println(res);
    }
}
