package com.macrodream.dsa.quiz.huawei;

import java.util.Scanner;

/**
 * @author Macros.Zhang
 * @date 4/2/2022 10:18
 *
 *
HJ2 计算某字符出现次数
题目
题解(508)
讨论(2k)
排行
简单  通过率：30.46%  时间限制：1秒  空间限制：32M
知识点
字符串
哈希
warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
描述
写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）

数据范围： 1 \le n \le 1000 \ 1≤n≤1000
输入描述：
第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。

输出描述：
输出输入字符串中含有该字符的个数。（不区分大小写字母）

示例1
输入：
ABCabc
A
复制
输出：
2
 */
public class HJ002_CharCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String ch = scanner.nextLine();
        System.out.println(charCount(str.toLowerCase(), ch.toLowerCase()));
        System.out.println(charCount1(str, ch));
    }

    /**
     * 减法
     * @param str
     * @param ch
     * @return
     */
    public static int charCount(String str,String ch){
        return str.length() - str.replaceAll(ch,"").length();
    }

    /**
     * 字符数组提升效率
     * @param str
     * @param ch
     * @return
     */
    public static int charCount1(String str,String ch){
        char[] chars = str.toLowerCase().toCharArray();
        char c = ch.toLowerCase().charAt(0);
        int len = chars.length;
        int count = 0;
        for (int i = 0; i < len ; i++) {
            if (chars[i] == c) {
                count++;
            }
        }
        return count;
    }
}
