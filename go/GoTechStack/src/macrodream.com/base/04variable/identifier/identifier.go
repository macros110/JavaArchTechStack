package main

import "fmt"

//golang中标识符使用
func main() {
	//Go中严格区分大小写
	var num int = 10
	var Num int = 20
	fmt.Printf("num=%v Num=%v \n", num, Num)

	//标识符不能包含空格
	//var ab c int = 30//syntax error: unexpected int at end of statement

	//_ 是空标识符，用于占用
	var _ int = 40
	//fmt.Println(_) //cannot use _ as value

	//语法上ok,不建议这样使用
	var int int = 90
	fmt.Println(int)
}
