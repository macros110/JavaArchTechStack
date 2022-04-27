package com.macrodream.javase.p01base.c03var;

/**
 * @author Macros.Zhang
 * @date 4/25/2022 22:56
 *      变量的概念
 *          内存中的一个存储区域
 *          该区域是数据可以在同一类型范围内不断变化
 *          变量是程序中最基本的存储单元。包含 变量类型、变量名 和 存储的值
 *      变量的作用
 *          用于在内存中保存数据
 *      使用注意
 *          Java中每个变量必须先声明(局部变量必须赋值)，后使用
 *          使用变量名来访问这块区域的数据
 *          变量的作用域，其定义所在的一对{} 内
 *          变量只有在其作用域内才有效
 *          同一作用域内，不能定义重名变量
 *      变量的使用
 *          1.定义变量格式： 数据类型 变量名 =  变量值;
 */
public class P01Variable {
    public static void main(String[] args) {
        /*变量定义*/
        int myAge = 25;
        /*变量使用*/
        System.out.println(myAge);


        /*编译错误： cannot find symbol:   variable myNumber*/
        /*System.out.println(myNumber);*/

        /*变量声明*/
        int myNumber;

        /*编译错误：variable myNumber might not have been initialized*/
        /*System.out.println(myNumber);*/

        /*变量赋值*/
        myNumber = 1001;
        System.out.println(myNumber);

        /*编译错误 ：Cannot resolve symbol 'myClass'*/
        /*System.out.println(myClass);*/

        /* 编译错误： Variable 'myAge' is already defined in the scope*/
        /*int myAge = 22;*/
    }

    public void method() {
        int myClass = 1;
    }
}

