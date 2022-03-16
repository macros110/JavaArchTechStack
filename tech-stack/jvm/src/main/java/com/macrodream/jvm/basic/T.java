package com.macrodream.jvm.basic;

/**
 * 解释 DCL 单例 实例加volatile
 */
public class T {
    public static void main(String[] args) {
        /**
         * 0 new #2 <com/macrodream/jvm/basic/T>
         * 3 dup
         * 4 invokespecial #3 <com/macrodream/jvm/basic/T.<init> : ()V>
         * 7 astore_1
         * 8 return
         */
        T t = new T();
    }
}
