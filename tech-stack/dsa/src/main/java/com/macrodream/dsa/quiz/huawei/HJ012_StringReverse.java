package com.macrodream.dsa.quiz.huawei;

import java.util.Scanner;

/**
 * @author Macros.Zhang
 * @date 4/5/2022 22:22
 * HJ12 字符串反转
 * 题目
 * 题解(229)
 * 讨论(933)
 * 排行
 * 简单  通过率：59.31%  时间限制：1秒  空间限制：32M
 * 知识点
 * 字符串
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 *
 * 输入描述：
 * 输入一行，为一个只包含小写字母的字符串。
 *
 * 输出描述：
 * 输出该字符串反转后的字符串。
 *
 * 示例1
 * 输入：
 * abcd
 * 复制
 * 输出：
 * dcba
 */
public class HJ012_StringReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int len = str.length();
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = len-1; i >= 0 ; i--) {
            sb.append(chars[i]);
        }
        System.out.println(sb);
    }
}
