package main

import "fmt"

//为什么需要变量
//一个程序就是一个世界
//变量是程序的基本组成单位

func getVal(num1 int, num2 int) (int, int) {
	sum := num1 + num2
	sub := num1 - num2
	return sum, sub
}

func main() {
	sum, sub := getVal(30, 30)
	fmt.Println("sum=", sum, "sub=", sub)
	sum2, _ := getVal(10, 30) //只取出第一个返回值
	fmt.Println("sum=", sum2)
}
