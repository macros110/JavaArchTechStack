package main

import "fmt"

//指针
func main() {
	//基本数据类型在内存中布局
	var i int = 10
	//i 的地址 用 &i
	fmt.Println("i的地址：", &i)

	//var ptr *int = &i
	//1 ptr是一个指针变量
	//2 ptr类型是 *int
	//3 ptr值是 &i
	var ptr *int = &i
	fmt.Printf("ptr=%v\n", ptr)
	fmt.Printf("ptr的地址=%v\n", &ptr)
	fmt.Printf("ptr指向的值=%v\n", *ptr)

	//练习  ptr -> 0x1400001e0b0 -> n -> 9
	var num int = 9
	fmt.Printf("num address=%v\n", &num)

	var ptr1 *int
	ptr1 = &num
	*ptr1 = 11 // 修改时，num值改变
	fmt.Println("num = ", num)
}
