package main

import "fmt"

//1 注释风格
//	使用行注释
//2 缩紧和空白
//	tab，整体右移，shift+tab 整体左移
//	gofmt 进行格式化
//gofmt codeStyle.go  输出格式化代码
//gofmt -w codeStyle.go  格式化代码并保存
//	运算符两边习惯各加一个空格 2 + 4 * 5
//3 代码风格 {不能单独一行
//go语言一个问题只有一个解决方法
//4 行风格约定	80字符  ,换行

func main() {
	//{  这个写法错误
	fmt.Println("Code Style")
	fmt.Println("Code Style")
	fmt.Println("Code Style")
	fmt.Println("Code Style")
	fmt.Println("Code Style")
	var num = 2 + 4*5
	fmt.Println(num)

	fmt.Println("HelloWorldHelloWorldHelloWorldHelloWorld\n",
		"HelloWorldHelloWorldHelloWorldHelloWorldHelloWorldHelloWorld\n",
		"HelloWorldHelloWorldHelloWorldHelloWorldHelloWorldHelloWorld\n",
		"HelloWorldHelloWorldHelloWorldHelloWorldHelloWorldHelloWorldHelloWorld")
}
