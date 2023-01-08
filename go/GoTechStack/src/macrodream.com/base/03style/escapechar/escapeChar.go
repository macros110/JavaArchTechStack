package main

import "fmt" //fmt包 格式化，输入输出

/**
转义字符
	\t	制表符，实现对齐
	\n	换行符
	\\	一个	\
	\"	一个"
	\r	一个回车
*/
func main() {
	fmt.Println("tom\tjerry")
	fmt.Println("hello\nworld")
	fmt.Println("C:\\Users\\Adiminstrator")
	fmt.Println("tom says\" i love you\"")
	// \r 回车，从当前行最前面大开始输出，覆盖掉以前内容
	fmt.Println("天龙八部雪山飞狐\r张飞厉害")

	fmt.Println("姓名\t年龄\t籍贯\t住址\njohn\t12\t河北\t北京")
}
