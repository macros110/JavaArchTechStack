package main

import (
	"fmt"
	"unsafe"
)

//整数类型
//类型	有无符号	占用存储空间（字节）	表数范围			备注
//int8	有		1					-128～127
//int16	有		2					-2^15~2^15-1
//int32 有		4					-2^31~2^31-1
//int64 有		8					-2^63~2^63-1
//uint8 有		1					0~255
//uint16 有		2					0~2^16-1
//uint32 有		4					0~2^32-1
//uint64 有		8					0~2^64-1
//int 	有		4（32位）8（64位）	-2^31~2^31-1(32位) -2^63~2^63-1(64位)
//uint 	无		4（32位）8（64位）	0~2^32-1(32位) 0~2^64-1(64位)
//rune 	有		4（和int32一样）		-2^31~2^31-1		等价于int32，表示一个Unicode码
//byte 	无		1（和unit8一样）		0~255				当要存储字符时选用byte

func main() {
	var i int = 1
	fmt.Println("i=", i)

	//测试一个int8当范围 -128～127，
	//int16，int32，int64
	var j int8 = 127
	fmt.Println("j=", j)
	//var j int8 = 128//constant 128 overflows int8
	//var j int8 = -129 //constant -129 overflows int8
	j = -128
	fmt.Println("j=", j)
	var j16 int16 = 1<<15 - 1
	fmt.Println("j16=", +j16)
	//j16 = 1 << 15//constant 32768 overflows int16
	j16 = -1 * 1 << 15
	//j16 = -1 * 1 << 15 -1//constant -32769 overflows int16
	fmt.Println("j16=", +j16)
	var j32 int32 = 1<<31 - 1
	fmt.Println("j32=", j32)
	//j32 = 1 << 31//constant 2147483648 overflows int32
	j32 = -1 * 1 << 31
	//j32 = -1 * 1 << 31 - 1//constant -2147483649 overflows int32
	fmt.Println("j32=", j32)
	var j64 int64 = 1<<63 - 1
	fmt.Println("j64=", j64)
	//j64 = 1 << 63//constant 9223372036854775808 overflows int64
	j64 = -1 * 1 << 63
	//j64 = -1 * 1 << 63 - 1//constant -9223372036854775809 overflows int64
	fmt.Println("j64=", j64)

	//测试unit8，unit16，unit32，unit64范围
	var u8 uint8 = 1<<8 - 1
	fmt.Println("u8=", u8)
	//u8 = 1 << 8//constant 256 overflows uint8
	//u8 = -1//constant -1 overflows uint8
	u8 = 0
	fmt.Println("u8=", u8)
	var u16 uint16 = 1<<16 - 1
	fmt.Println("u16=", u16)
	//u16 = 1 << 16//constant 65536 overflows uint16
	var u32 uint32 = 1<<32 - 1
	//u32 = 1 << 32//constant 4294967296 overflows uint32
	fmt.Println("u32=", u32)
	var u64 uint64 = 1<<64 - 1
	//u64 = 1 << 64//constant 18446744073709551616 overflows uint64
	fmt.Println("u64=", u64)

	//int, unit, rune, byte的使用
	var a int = 8900
	fmt.Println("a=", a)
	//a = 1 << 63//constant 9223372036854775808 overflows int
	a = 1<<63 - 1
	fmt.Println("a=", a)
	a = -1 * 1 << 63
	//a = -1 * 1 << 63 - 1//constant -9223372036854775809 overflows int
	fmt.Println("a=", a)
	var b uint = 1<<64 - 1
	//b = 1 << 64//constant 18446744073709551616 overflows uint
	fmt.Println("b=", b)
	var ru rune = 1<<31 - 1
	//ru = 1 << 31//constant 2147483648 overflows rune
	fmt.Println("ru=", ru)
	ru = -1 * 1 << 31
	//ru = -1 * 1 << 31 - 1//constant -2147483649 overflows rune
	fmt.Println("ru=", ru)
	var by byte = 1<<8 - 1
	//by = 1 << 8//constant 256 overflows byte
	fmt.Println("by=", by)

	//整数使用细节
	var n1 = 100 //？n1 是什么类型
	//如何查看某个变量的数据类型
	//fmt.Printf() 可用于做格式化输出
	fmt.Printf("n1 的 类型 %T \n", n1)

	//如何查看某个变量的占用字节大小和数据类型（常用）
	var n2 int64 = 10
	//unsafe.Sizeof(n2) 是unsafe包的一个函数，可以返回n2变量占用字节数
	fmt.Printf("n2 的 类型 %T  n2占用的字节数是 %d \n", n2, unsafe.Sizeof(n2))

	//保小不保大，即 在程序正确运行下，尽量使用占用空间小的数类型
	var age byte = 90
	fmt.Println("age=", age)

	//bit计算机最小存储单位比特，byte=8bit 计算机中基本存储但愿 字节
}
