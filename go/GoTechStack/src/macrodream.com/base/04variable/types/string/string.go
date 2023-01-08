package main

import "fmt"

//字符串类型 string
//基本介绍
//字符串是一串固定长度的字符连接起来的字符序列
//Go字符串是由单个字节连接起来的
//Go语言字符串字节使用UTF-8编码标识Unicode文本
//注意事项和使用细节
//1 字符串统一使用UTF-8编码标识Unicode文本，没有（中文）乱码问题
//2 字符串不可变，一旦赋值无法修改
//3 字符串两种表示形式
//双引号，会识别转义字符
//反引号，以字符串的原生形式输出，包括换行和特殊字符，可以事项防止攻击、输出源代码等效果
//4 字符串拼接方式
//5 当一行字符串太长时，需要使用到多行字符串，可以在前一行尾用+拼接
func main() {
	var address string = "上海东方明珠 021 hello world!"
	fmt.Println(address)

	//2 字符串不可变，一旦赋值无法修改
	var str = "hello"
	//str[0] = 'y'//cannot assign to str[0] (strings are immutable)
	fmt.Println(str)

	//3 字符串两种表示形式
	//双引号""，会识别转义字符
	str2 := "abc\nabc"
	fmt.Println(str2)
	//反引号``，以字符串的原生形式输出，包括换行和特殊字符，可以事项防止攻击、输出源代码等效果
	str3 := `
	package main
	import (
		"fmt"
		"unsafe"
	)
	func main()  {
		b := false
		fmt.Println("b=", b)
		//注意事项
		//1 bool类型占用存储空间是1个字节
		fmt.Println("b的占用空间 =", unsafe.Sizeof(b))
		//2 bool类型只能取true或false
		//b = 1 //cannot use 1 (type untyped int) as type bool in assignment
	}
	`
	fmt.Println(str3)

	//4 字符串拼接方式
	var str4 = "hello " + "world"
	str4 += " haha!"
	fmt.Println(str4)
	//5 当一行字符串太长时，需要使用到多行字符串，可以在前一行尾用+拼接,+保留到上一行
	//str5 := "hello " + "world" + "hello " + "world" + "hello " + "world"
	//+ "hello " + "world" + "hello " + "world" + "hello " + "world"
	//+ "hello " + "world"
	str5 := "hello " + "world" + "hello " + "world" + "hello " + "world" +
		"hello " + "world" + "hello " + "world" + "hello " + "world" +
		"hello " + "world"
	fmt.Println(str5)

}
