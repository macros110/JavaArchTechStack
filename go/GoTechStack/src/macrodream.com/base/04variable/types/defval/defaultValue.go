package main

import "fmt"

//基本数据类型默认值
//没赋值使用默认值，又叫零值
//数据类型	默认值
//整型		0
//浮点型		0
//复数型
//字符串		""
//布尔型		false
func main() {
	var i int           //0
	var f32 float32     //0
	var f64 float64     //0
	var c64 complex64   //0+0i
	var c128 complex128 //0+0i
	var isMarried bool  //false
	var str string      //""
	//这里%v表示按照变量的值输出
	fmt.Printf("i=%v,f32=%v,f64=%v,c64=%v,c128=%v,isMarried=%v,str=%v", i, f32, f64,
		c64, c128, isMarried, str)

}
