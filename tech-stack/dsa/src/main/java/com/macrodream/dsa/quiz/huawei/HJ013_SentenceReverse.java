package com.macrodream.dsa.quiz.huawei;

import java.util.Scanner;

/**
 * @author Macros.Zhang
 * @date 4/5/2022 22:35
 *
HJ13 句子逆序
题目
题解(282)
讨论(1k)
排行
简单  通过率：40.22%  时间限制：1秒  空间限制：32M
知识点
数组
warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
描述
将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”

所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符

数据范围：输入的字符串长度满足 1 \le n \le 1000 \ 1≤n≤1000

注意本题有多组输入
输入描述：
输入一个英文语句，每个单词用空格隔开。保证输入只包含空格和字母。

输出描述：
得到逆序的句子

示例1
输入：
I am a boy
复制
输出：
boy a am I
复制
示例2
输入：
nowcoder
复制
输出：
nowcoder

 */
public class HJ013_SentenceReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(" ");
        int len = strs.length;
        for (int i = len - 1; i >=0 ; i--) {
            System.out.print(strs[i]);
            if (i != 0) {
                System.out.print(" ");
            }
        }
    }
}
