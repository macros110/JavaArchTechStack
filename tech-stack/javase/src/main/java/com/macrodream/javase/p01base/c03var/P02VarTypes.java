package com.macrodream.javase.p01base.c03var;

/**
 * @author Macros.Zhang
 * @date 4/26/2022 07:42
 *
 *      变量类型（强类型）
 *          数据类型
 *              基本（primitive type）
 *                  数值型
 *                      整数类型
 *                          byte
 *                          short
 *                          int
 *                          long
 *                      浮点类型
 *                          float
 *                          double
 *                  字符型
 *                      char
 *                  布尔型
 *                      boolean
 *              引用（reference type）
 *                  类（class） 字符串
 *                  接口(interface)
 *                  数值([])
 *                  枚举(enum)
 *          声明位置
 *              成员变量(类体声明)
 *                  实例变量 （不以static修饰）
 *                  类变量(以static修饰)
 *              局部变量(方法体声明)
 *                  形参(方法、构造器中定义)
 *                  方法局部变量(方法体内定义)
 *                  代码块局部变量(在代码块内定义)
 *              异同
 *                  同
 *                      都有声命周期
 *                  异
 *                      局部变量除形参外，需显式初始化
 */
public class P02VarTypes {
    public static void main(String[] args) {
        /*
        *   整型类型
        *       固定表数范围和长度，不受OS影响，保证可移植性
        *       整型常量默认为int型，声明long常量后加l后L
        *       变量通常声明int，除非不足表示较大数，采用long
        *       类型      占用存储空间      表数范围
        *       byte    1字节(byte) = 8bit位     -128~127
        *       short   2字节             -2^15~2^15-1
        *       int     4字节             -2^31~2^31-1(约21亿)
        *       long    8字节             -2^63~2^63-1
        */
        byte b1 = 12;
        byte b2 = -128;

        /*编译错误 incompatible types: possible lossy conversion from int to byte*/
        /*b2 = 128;*/

        System.out.println(b1);
        System.out.println(b2);

        /*声明long，必须l后L结尾*/
        short s1 = 128;
        int i1 = 1234;
        long l1 = 3414234324L;
        System.out.println(l1);

        /*
            浮点型
                固定表数范围和字段长度
                浮点常量两种表示形式
                    十进制数形式  5.12    512.0f  .512 (必须有小数点)
                    科学计数法形式     5.12e2      512E2    100E-2
                float 单精度，尾数精确到7位，精度很难满足
                double 双精度，精度是float的2倍。通常采用
                浮点常量默认double，声明float常量，后加f或F
                类型      占用存储空间      表数范围
                float       4字节         -3.403E38~3.403E38
                double      8字节         -1.798E308~1.798E308
         */
        double d1 = 123.3;
        System.out.println(d1 + 1);
        float f1 = 12.3F;
        System.out.println(f1);

        /*
            字符型 char (1字符=2字节)
                char变量，用'',内部只能有一个字符
                Unicode编码
                字符变量三种表现形式
                    '字符'
                    转义字符 \b  \n  \r  \t  \"  \'  \\
                    Unicode表示 uXXXX    '\u000a'表示 \n
                char可以进行运算，对应Unicode码
                ASCII码
                    计算机内部，一个字节，可表示256个符号
                    128个字符，只占用7位，最高位统一为0
                    缺点
                        不能表示所有字符
                        相同编码表示字符不一样，130法语编码和希伯来语编码代表字母不一样
                UTF-8
                    互联网使用最广泛的一种Unicode实现方式
                    一种变长的编码方式。1-6个字节表示一个符号，根据不同的符号而变化字节长度
                    编码规则
                        单字节，最高位0，其余7位进行编码，等同ASCII码
                        n字节（n>1），第一个字节的前n位为1，第一个字节的第n+1位为0，该字节剩余各位对字符进行编码。
                            之后所有字节，最高两位10，其余6位对字符进行编码。
         */
        char c1 = 'a';
        /*编译错误Too many characters in character literal*/
        /*c1 = 'AB';*/
        System.out.println(c1);

        char c2 = '1';
        char c3 = '中';
        char c4 = 'ス';
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);

        /*换行符*/
        char c5 = '\n';
        /*制表符*/
        c5 = '\t';
        System.out.print("hello" + c5);
        System.out.println("world");

        char c6 = '\u0043';
        System.out.println(c6);

        /*
            布尔型 boolean
                只能取true/false
                常常条件判断、循环结构中使用
         */
        boolean bool1 = true;
        System.out.println(bool1);

        boolean isMarried = true;
        if (isMarried) {
            System.out.println("你就不能参加单身Party了！很遗憾");
        } else {
            System.out.println("你可以多谈谈女朋友！");
        }
    }
}
