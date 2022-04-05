package com.macrodream.dsa.quiz.huawei;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Macros.Zhang
 * @date 4/2/2022 10:47
 * HJ3 明明的随机数
 * 题目
 * 题解(463)
 * 讨论(1k)
 * 排行
 * 较难  通过率：21.92%  时间限制：1秒  空间限制：32M
 * 知识点
 * 数组
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 明明生成了NN个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
 *
 * 数据范围： 1 \le n \le 1000 \ 1≤n≤1000  ，输入的数字大小满足 1 \le val \le 500 \ 1≤val≤500
 * 输入描述：
 * 第一行先输入随机整数的个数 N 。 接下来的 N 行每行输入一个整数，代表明明生成的随机数。 具体格式可以参考下面的"示例"。
 * 输出描述：
 * 输出多行，表示输入数据处理后的结果
 *
 * 示例1
 * 输入：
 * 3
 * 2
 * 2
 * 1
 * 复制
 * 输出：
 * 1
 * 2
 * 复制
 * 说明：
 * 输入解释：
 * 第一个数字是3，也即这个小样例的N=3，说明用计算机生成了3个1到500之间的随机整数，接下来每行一个随机数字，共3行，也即这3个随机数字为：
 * 2
 * 2
 * 1
 * 所以样例的输出为：
 * 1
 * 2
 */
public class HJ003_RemoveRepeatedRand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num_count = scanner.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < num_count; i++) {
            int num = scanner.nextInt();
            set.add(num);
        }
        set.forEach(item -> System.out.println(item));
    }
}
