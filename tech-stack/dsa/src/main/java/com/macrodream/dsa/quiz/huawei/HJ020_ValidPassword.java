package com.macrodream.dsa.quiz.huawei;

import java.util.Scanner;

/**
 * @author Macros.Zhang
 * @date 4/13/2022 20:24
 * HJ20 密码验证合格程序
 * 题目
 * 题解(209)
 * 讨论(722)
 * 排行
 * 中等  通过率：29.42%  时间限制：1秒  空间限制：32M
 * 知识点
 * 字符串
 * 数组
 * 模拟
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 密码要求:
 *
 * 1.长度超过8位
 *
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 *
 * 3.不能有长度大于2的不含公共元素的子串重复 （注：其他符号不含空格或换行）
 *
 * 数据范围：输入的字符串长度满足 1 \le n \le 100 \ 1≤n≤100
 * 输入描述：
 * 一组字符串。
 *
 * 输出描述：
 * 如果符合要求输出：OK，否则输出NG
 *
 * 示例1
 * 输入：
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 * 复制
 * 输出：
 * OK
 * NG
 * NG
 * OK
 * 复制
 * 相似企业真题
 */
public class HJ020_ValidPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String pw = scanner.nextLine();
            if ("".equals(pw)) {
                return;
            }
            if (pw.length() <= 8) {
                System.out.println("NG");
                continue;
            }
            if (!has3TypeChar(pw)) {
                System.out.println("NG");
                continue;
            }
            if (hasRepeatedStr(pw)) {
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }

    private static boolean has3TypeChar(String pw) {
        char[] chars = pw.toCharArray();
        int a = 0,b = 0, d = 0, e = 0;
        for(char c: chars) {
            if (c == ' ' || c == '\n') {
                return false;
            }
            if (c >= '0' && c <='9') {
                a = 1;
                continue;
            }
            if (c >= 'a' && c <='z') {
                b = 1;
                continue;
            }
            if (c >= 'A' && c <='Z') {
                d = 1;
                continue;
            }
            e = 1;
        }
        if ((a + b + d + e) >= 3) {
            return true;
        }
        return false;
    }

    private static boolean hasRepeatedStr(String pw) {
        for (int i = 3; i < pw.length(); i++) {
            if (pw.substring(i).contains(pw.substring(i-3,i))) {
                return true;
            }
        }
        return false;
    }
}
