package com.macrodream.dsa.quiz.huawei;

import java.util.Scanner;

/**
 * @author Macros.Zhang
 * @date 4/5/2022 10:43
 * HJ4 字符串分隔
 * 题目
 * 题解(564)
 * 讨论(1k)
 * 排行
 * 简单  通过率：28.70%  时间限制：1秒  空间限制：32M
 * 知识点
 * 字符串
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 *
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述：
 * 连续输入字符串(每个字符串长度小于等于100)
 *
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 *
 * 示例1
 * 输入：
 * abc
 * 复制
 * 输出：
 * abc00000
 */
public class HJ004_StringSplit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        stringSplit(str);
    }

    private static void stringSplit(String str) {
        int splitCount = 8;
        int len = str.length();
        char[] chars = str.toCharArray();
        int offset = 0 == len % splitCount ? 0 : splitCount - len % splitCount;
        for (int i = 0; i < len; i++) {
            System.out.print(chars[i]);
            if ((i+1) % splitCount == 0) {
                System.out.println();
            }
        }
        for (int i = 0; i < offset; i++) {
            System.out.print(0);
        }
    }
}
