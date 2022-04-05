package com.macrodream.dsa.quiz.huawei;

import java.util.Scanner;

/**
 * @author Macros.Zhang
 * @date 4/2/2022 09:45
 * 
 * 描述
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 * 输入描述：
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 *
 * 输出描述：
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 *
 * 示例1
 * 输入：
 * hello nowcoder
 * 复制
 * 输出：
 * 8
 * 复制
 * 说明：
 * 最后一个单词为nowcoder，长度为8   
 *
 */
public class HJ001_LastWordLen {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(lastWordLen(str));
        System.out.println(lastWordLen1(str));
        System.out.println(lastWordLen2(str));
    }

    /**
     * 逆序历遍字符串
     * @param str
     * @return
     * @throws Exception
     */
    public static int lastWordLen(String str) throws Exception {
        checkStrValid(str);
        int count = 0;
        int len = str.length();
        for (int i = len-1; i >=0; i--) {
            if (str.charAt(i) == ' ') {
                break;
            }
            count++;
        }
        return count;
    }

    /**
     * 逆序用数组历遍 提升时间效率
     * @param str
     * @return
     * @throws Exception
     */
    public static int lastWordLen1(String str) throws Exception {
        checkStrValid(str);
        int count = 0;
        int len = str.length();
        char[] chars = str.toCharArray();
        for (int i = len-1; i >=0; i--) {
            if (chars[i] == ' ') {
                break;
            }
            count++;
        }
        return count;
    }

    public static int lastWordLen2(String str) throws Exception {
        checkStrValid(str);
        String[] strs = str.split(" ");
        int len = strs.length;
        return strs[len-1].length();
    }

    private static void checkStrValid(String str) throws Exception {
        if (str == null) {
            throw new Exception("字符串为空！");
        }
        if (str.length() >= 5000) {
            throw new Exception("字符串长度大于等于5000！");
        }
    }


}
