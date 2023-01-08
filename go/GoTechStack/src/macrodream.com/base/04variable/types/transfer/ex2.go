package main

import "fmt"

func main() {
	//练习
	var n1 int32 = 12
	var n3 int8
	var n4 int8

	n4 = int8(n1) + 127 // 编译通过，结果溢出
	//n3 = int8(n1) + 128 // 编译不通过 constant 128 overflows int8
	fmt.Println("n4=", n4, "n3=", n3)
}
