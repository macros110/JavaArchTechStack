package main

import "fmt"

func main() {
	//练习
	var n1 int32 = 12
	var n2 int64
	var n3 int8

	//n2 = n1 + 20 //int32 >> int64 error cannot use n1 + 20 (type int32) as type int64 in assignment
	//n3 = n1 + 20 //int32 >> int8 error cannot use n1 + 20 (type int32) as type int64 in assignment
	n2 = int64(n1) + 20
	n3 = int8(n1) + 20
	fmt.Println("n2=", n2, "n3=", n3)
}
