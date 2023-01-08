package main

import "fmt"

//行注释

/*块注释（多行注释）

 */

//注释文字，不会被Go编译器执行
//块注释里面不允许有块注释嵌套
//官网推荐使用行注释

//command + /   注释和取消注释
func main() {
	fmt.Println(1111)
	fmt.Println(1111)
	fmt.Println(1111)
	fmt.Println(1111)
	//fmt.Println(1111)
	//fmt.Println(1111)
}
