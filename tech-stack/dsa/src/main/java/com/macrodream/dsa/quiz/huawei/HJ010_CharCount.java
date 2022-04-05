package com.macrodream.dsa.quiz.huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Macros.Zhang
 * @date 4/5/2022 21:46
 * HJ10 字符个数统计
 * 题目
 * 题解(358)
 * 讨论(1k)
 * 排行
 * 简单  通过率：47.52%  时间限制：1秒  空间限制：32M
 * 知识点
 * 字符串
 * 哈希
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在 ASCII 码范围内( 0~127 ，包括 0 和 127 )，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串 abaca 而言，有 a、b、c 三种不同的字符，因此输出 3 。
 *
 * 数据范围： 1 \le n \le 500 \ 1≤n≤500
 * 输入描述：
 * 输入一行没有空格的字符串。
 *
 * 输出描述：
 * 输出 输入字符串 中范围在(0~127，包括0和127)字符的种数。
 *
 * 示例1
 * 输入：
 * abc
 * 复制
 * 输出：
 * 3
 * 复制
 * 示例2
 * 输入：
 * aaa
 * 复制
 * 输出：
 * 1
 */
public class HJ010_CharCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int len = str.length();
        char[] chars = str.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(chars[i]);
        }
        System.out.println(set.size());
    }
}
