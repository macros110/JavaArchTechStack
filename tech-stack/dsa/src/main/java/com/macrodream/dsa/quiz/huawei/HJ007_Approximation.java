package com.macrodream.dsa.quiz.huawei;

import java.util.Scanner;

/**
 * @author Macros.Zhang
 * @date 4/5/2022 12:42
 * HJ7 取近似值
 * 题目
 * 题解(69)
 * 讨论(1k)
 * 排行
 * 入门  通过率：50.22%  时间限制：1秒  空间限制：32M
 * 知识点
 * 基础数学
 * 语法题
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于 0.5 ,向上取整；小于 0.5 ，则向下取整。
 *
 * 数据范围：保证输入的数字在 32 位浮点数范围内
 * 输入描述：
 * 输入一个正浮点数值
 *
 * 输出描述：
 * 输出该数值的近似整数值
 *
 * 示例1
 * 输入：
 * 5.5
 * 复制
 * 输出：
 * 6
 * 复制
 * 说明：
 * 0.5>=0.5，所以5.5需要向上取整为6
 * 示例2
 * 输入：
 * 2.499
 * 复制
 * 输出：
 * 2
 * 复制
 * 说明：
 * 0.499<0.5，2.499向下取整为2
 *
 *
 * float 32 bit   double 64 bit
 */
public class HJ007_Approximation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        System.out.println((int)(num+0.5));
    }
}
