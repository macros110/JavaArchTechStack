package com.macrodream.dsa.quiz.huawei;

import java.util.Scanner;

/**
 * @author Macros.Zhang
 * @date 4/5/2022 11:32
 */
public class HJ005_HexToDec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hex = scanner.nextLine();
        System.out.println(hexToDec(hex));
        //System.out.println(Integer.valueOf("AA",16));
    }

    private static String hexToDec(String hex) {
        return Integer.valueOf(hex.substring(2),16).toString();
    }
}
