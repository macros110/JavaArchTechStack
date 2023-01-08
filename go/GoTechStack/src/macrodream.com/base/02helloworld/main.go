//包名
package main

//导入语句
import "fmt"

//函数外只能防止标识符（变量/常量/函数/类型）的声明
//fmt.Println("Hello World")// syntax error: non-declaration statement outside function body
/**
 两中运行go程序等方式
	1编译后运行
		go build main.go
		./main
	2直接运行
		go run main.go
Golang执行流程分析
	.go文件>>go build 编译>>可执行文件>>运行>>结果（包含go运行环境，不用机器中有go运行环境）
	.go文件>>go run 编译运行 >> 结果（必须有go运行环境）
编译运行注意
	编译可以执行文件为二进制文件
	可以指定可执行文件名字
		go build -o mymain main.go
	编译无错可以生成可执行文件，编译有错会报错可执行文件无法生成
Go程序开发注意事项
	Go源程序必须以go为扩展名
	Go应用程序等执行入口是main函数（必须在package main里）
	严格区分大小写
	Go方法由一条条语句构成，无需分号（自动加分号）,或者两个语句之间加分号
	Go语言定义变量或者import等包如果没有用到，代码不能通过编译
	大括号都是成对出现
*/
//程序的入口函数
func main() {
	fmt.Println("Hello World")
	fmt.Println("人生苦短，Let's Go!")
	fmt.Println("Hello World Go")
	fmt.Println("人生苦短，Let's Go Go！")
}
