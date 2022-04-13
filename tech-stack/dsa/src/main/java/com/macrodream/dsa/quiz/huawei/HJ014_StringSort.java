package com.macrodream.dsa.quiz.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Macros.Zhang
 * @date 4/5/2022 22:49
 * HJ14 字符串排序
 * 题目
 * 题解(280)
 * 讨论(1k)
 * 排行
 * 简单  通过率：41.72%  时间限制：1秒  空间限制：32M
 * 知识点
 * 字符串
 * 排序
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 给定 n 个字符串，请对 n 个字符串按照字典序排列。
 *
 * 数据范围： 1 \le n \le 1000 \ 1≤n≤1000  ，字符串长度满足 1 \le len \le 100 \ 1≤len≤100
 * 输入描述：
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述：
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 * 示例1
 * 输入：
 * 9
 * cap
 * to
 * cat
 * card
 * two
 * too
 * up
 * boat
 * boot
 * 复制
 * 输出：
 * boat
 * boot
 * cap
 * card
 * cat
 * to
 * too
 * two
 * up
 */
public class HJ014_StringSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*按行来，不然循环中会识别一个空行*/
        int n = Integer.valueOf(scanner.nextLine());
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.nextLine();
        }
        /*Arrays.stream(strs).sorted().forEach(v -> System.out.println(v));*/
        Arrays.stream(strs).sorted().forEach(System.out::println);
    }
}
