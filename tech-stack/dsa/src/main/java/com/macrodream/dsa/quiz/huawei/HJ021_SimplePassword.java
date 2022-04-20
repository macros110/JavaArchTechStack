package com.macrodream.dsa.quiz.huawei;

import java.util.Scanner;

/**
 * @author Macros.Zhang
 * @date 4/15/2022 12:05
 * HJ21 简单密码
 * 题目
 * 题解(260)
 * 讨论(781)
 * 排行
 * 简单  通过率：41.93%  时间限制：1秒  空间限制：32M
 * 知识点
 * 字符串
 * 模拟
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 现在有一种密码变换算法。
 * 九键手机键盘上的数字与字母的对应： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0，把密码中出现的小写字母都变成九键键盘对应的数字，如：a 变成 2，x 变成 9.
 * 而密码中出现的大写字母则变成小写之后往后移一位，如：X ，先变成小写，再往后移一位，变成了 y ，例外：Z 往后移是 a 。
 * 数字和其它的符号都不做变换。
 * 数据范围： 输入的字符串长度满足 1 \le n \le 100 \ 1≤n≤100
 * 输入描述：
 * 输入一组密码，长度不超过100个字符。
 *
 * 输出描述：
 * 输出密码变换后的字符串
 *
 * 示例1
 * 输入：
 * YUANzhi1987
 * 复制
 * 输出：
 * zvbo9441987
 */
public class HJ021_SimplePassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ln = scanner.nextLine();
        char[] cs = ln.toCharArray();
        for (char c : cs) {
            if (c >= 'a' && c <='c') {
                System.out.print(2);
                continue;
            }
            if (c >= 'd' && c <='f') {
                System.out.print(3);
                continue;
            }
            if (c >= 'g' && c <='i') {
                System.out.print(4);
                continue;
            }
            if (c >= 'j' && c <='l') {
                System.out.print(5);
                continue;
            }
            if (c >= 'm' && c <='o') {
                System.out.print(6);
                continue;
            }
            if (c >= 'p' && c <='s') {
                System.out.print(7);
                continue;
            }
            if (c >= 't' && c <='v') {
                System.out.print(3);
                continue;
            }
            if (c >= 'w' && c <='z') {
                System.out.print(9);
                continue;
            }
            if (c >= 'A' && c <='Y') {
                System.out.print((char)(c+33));
                continue;
            }
            if (c == 'Z') {
                System.out.print('a');
                continue;
            }
            System.out.print(c);
        }
    }
}
