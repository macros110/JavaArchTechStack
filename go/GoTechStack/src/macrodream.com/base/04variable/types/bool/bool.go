package main

import (
	"fmt"
	"unsafe"
)

//布尔类型bool
//基本介绍
//1 布尔类型也叫bool类型，只允许true和false
//2 bool类型占1个字节
//3 bool了适用于逻辑运算，一般永远程序流程控制（条件/循环）
//if条件控制语句
//for循环控制语句
//
func main() {
	b := false
	fmt.Println("b=", b)
	//注意事项
	//1 bool类型占用存储空间是1个字节
	fmt.Println("b的占用空间 =", unsafe.Sizeof(b))
	//2 bool类型只能取true或false
	//b = 1 //cannot use 1 (type untyped int) as type bool in assignment

}
