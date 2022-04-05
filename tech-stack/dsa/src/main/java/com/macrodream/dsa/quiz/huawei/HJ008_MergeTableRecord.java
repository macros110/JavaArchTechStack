package com.macrodream.dsa.quiz.huawei;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Macros.Zhang
 * @date 4/5/2022 12:47
 *
 * HJ8 合并表记录
 * 题目
 * 题解(347)
 * 讨论(1k)
 * 排行
 * 简单  通过率：35.12%  时间限制：1秒  空间限制：32M
 * 知识点
 * 哈希
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照index值升序进行输出。
 *
 *
 * 提示:
 * 0 <= index <= 11111111
 * 1 <= value <= 100000
 *
 * 输入描述：
 * 先输入键值对的个数n（1 <= n <= 500）
 * 接下来n行每行输入成对的index和value值，以空格隔开
 *
 * 输出描述：
 * 输出合并后的键值对（多行）
 *
 * 示例1
 * 输入：
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 * 复制
 * 输出：
 * 0 3
 * 1 2
 * 3 4
 * 复制
 * 示例2
 * 输入：
 * 3
 * 0 1
 * 0 2
 * 8 9
 * 复制
 * 输出：
 * 0 3
 * 8 9
 *
 */
public class HJ008_MergeTableRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int i = 0; i < size; i++) {
            int key = scanner.nextInt();
            int val = scanner.nextInt();
            mp.put(key, mp.getOrDefault(key,0) + val);
        }
        mp.forEach((key,val) -> System.out.println(key + " " + val));
    }
}
