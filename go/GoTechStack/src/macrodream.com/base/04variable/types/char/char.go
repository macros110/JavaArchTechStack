package main

import "fmt"

//字符类型（char）
//Go里没有专门字符类型，一般用byte保存
//Go字符串有"字节"组成
//说明
//1 字符在ASCII表，0-255,直接保存到byte
//2 保存对应码值大于255，考虑int/unit类型保存
//3 使用格式化输出 fmt.Printf("%c", c1)
//使用细节
//1 字符常量用''单引号括起来
//2 允许转义字符，通过\变为特殊字符常量
//\a	响铃
//\b	退格
//\f	换页
//\n	换行
//\r	回车
//\t	制表符
//\v	垂直制表符
//\'	单引号（只用在'\''形式的rune符号面值中）
//\"	双引号（只用在"..."形式的字符串面值中）
//\\	反斜杠
//3 字符使用UTF-8编码
//英文字母-1个字节
//汉字-3个字节
//4 字符串本质是一个整数，直接输出为该字符的UTF-8编码的码值
//5 直接给变量赋一个数字，格式化输出%c，会输出该数字的unicode字符
//6 字符类型可以进行运算，相当于一个整数，因为它都有对应的Unicode码
//字符类型本质探讨
//1 字符型存储到计算机中，需要将对应码值（整数）找出来
//存储：字符 >> 对应码值 >> 二进制 >> 存储
//读取：二进制 >> 码值 >> 字符 >> 读取
//2 字符和码值的对应关系是通过字符编码表决定的（是规定好）
//3 Go语言编码统一成utf-8。非常方便，没有乱码困扰（对比php，java）

func main() {
	var c1 byte = 'a'
	var c2 byte = '0'
	//直接输出byte值，输出对于字符的码值
	fmt.Println("c1=", c1)
	fmt.Println("c2=", c2)
	//使用格式化输出字符
	fmt.Printf("c1=%c c2=%c \n", c1, c2)

	var c0 byte = 0
	var c255 byte = 255
	fmt.Printf("c0=%c c255=%c\n", c0, c255)
	for i := 0; i < 256; i++ {
		fmt.Printf("c%d=%c\n", i, i)
	}

	//var c3 byte = '北'//constant 21271 overflows byte
	var c3 int = '北'
	fmt.Printf("c3=%c c3对应码值=%d\n", c3, c3)

	//5 直接给变量赋一个数字，格式化输出%c，会输出该数字的unicode字符
	var c4 int = 22269 //22269 >> '国'
	fmt.Printf("c4=%c\n", c4)
	//6 字符类型可以进行运算，相当于一个整数，因为它都有对应的Unicode码
	var n1 = 10 + 'a' //10 + 97 = 107
	fmt.Println("n1=", n1)
	fmt.Printf("n1=%c\n", n1)
	fmt.Printf("n1=%v\n", n1)
}
