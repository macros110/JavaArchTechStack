package com.macrodream.dsa.quiz.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Macros.Zhang
 * @date 4/13/2022 15:44
 *
 * 坚持刷题可以获得牛币和挂件等多种奖励，点击此处立即进入活动页面
 *
 * HJ17 坐标移动
 * 题目
 * 题解(354)
 * 讨论(1k)
 * 排行
 * 中等  通过率：25.28%  时间限制：1秒  空间限制：32M
 * 知识点
 * 字符串
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 *
 * 输入：
 *
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 *
 * 坐标之间以;分隔。
 *
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 *
 * 下面是一个简单的例子 如：
 *
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 *
 * 处理过程：
 *
 * 起点（0,0）
 *
 * +   A10   =  （-10,0）
 *
 * +   S20   =  (-10,-20)
 *
 * +   W10  =  (-10,-10)
 *
 * +   D30  =  (20,-10)
 *
 * +   x    =  无效
 *
 * +   A1A   =  无效
 *
 * +   B10A11   =  无效
 *
 * +  一个空 不影响
 *
 * +   A10  =  (10,-10)
 *
 * 结果 （10， -10）
 *
 * 数据范围：每组输入的字符串长度满足 1\le n \le 10000 \ 1≤n≤10000  ，坐标保证满足 -2^{31} \le x,y \le 2^{31}-1 \ −2
 * 31
 *  ≤x,y≤2
 * 31
 *  −1  ，且数字部分仅含正数
 * 输入描述：
 * 一行字符串
 *
 * 输出描述：
 * 最终坐标，以逗号分隔
 *
 * 示例1
 * 输入：
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 复制
 * 输出：
 * 10,-10
 * 复制
 * 示例2
 * 输入：
 * ABC;AKL;DA1;
 * 复制
 * 输出：
 * 0,0
 */
public class HJ017_CoordinateMovement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> mp = new HashMap<>();
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int x = 0;
            int y = 0;
            String[] ss = s.split(";");
            String reg = "[ADWS]\\d+";
            for (int i = 0; i < ss.length; i++) {
                if (ss[i].matches(reg)) {
                    mp.put(ss[i].charAt(0), mp.getOrDefault(ss[i].charAt(0),0) + Integer.valueOf(ss[i].substring(1)));
                }
            }
            x = x - mp.getOrDefault('A', 0) + mp.getOrDefault('D',0);
            y = y - mp.getOrDefault('S',0) + mp.getOrDefault('W', 0);
            System.out.println(x + "," + y);
            mp.clear();
        }
        scanner.close();
    }
}
