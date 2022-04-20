package com.macrodream.dsa.quiz.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Macros.Zhang
 * @date 4/15/2022 17:11
 * 坚持刷题可以获得牛币和挂件等多种奖励，点击此处立即进入活动页面
 *
 * HJ23 删除字符串中出现次数最少的字符
 * 题目
 * 题解(264)
 * 讨论(847)
 * 排行
 * 简单  通过率：33.84%  时间限制：1秒  空间限制：32M
 * 知识点
 * 字符串
 * 哈希
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 *
 * 数据范围：输入的字符串长度满足 1 \le n \le 20 \ 1≤n≤20  ，保证输入的字符串中仅出现小写字母
 * 输入描述：
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 *
 * 输出描述：
 * 删除字符串中出现次数最少的字符后的字符串。
 *
 * 示例1
 * 输入：
 * aabcddd
 * 复制
 * 输出：
 * aaddd
 */
public class HJ023_DelLeastChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ln = scanner.nextLine();
        Map<Character, Integer>  m = new HashMap<>();
        char[] cs = ln.toCharArray();
        for (char c : cs) {
            m.put(c, m.getOrDefault(c,0) + 1);
        }
        int min = Integer.MAX_VALUE;
        for (Integer v : m.values()) {
            min = Math.min(v, min);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            if (min == m.get(c)) {
                continue;
            }
            sb.append(c);
        }
        System.out.println(sb);
    }
}
