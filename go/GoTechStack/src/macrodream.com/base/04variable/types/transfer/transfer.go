package main

import (
	"fmt"
	"strconv"
)

//基本数据类型的转换
//Go不同变量之间赋值需要显示转换，不能自动转换
//基本语法 T(v)
//细节说明
//1 范围大 >> 范围小 ，范围小 >> 范围大
//2 被转换的是变量存储的数据（值），变量本身的数据类型没有变化
//3 int64转换int8，编译不会报错，转换结果是按溢出处理，可能和希望不一样

//基本数据类型和string转换
//基本数据类型>>string
//方式1 fmt.Sprintf("%参数",表达式)  灵活
//1 参数需要和表达式的数据类型相匹配
//2 fmt.Sprintf()..会返回转换后的字符串
//方式2 使用strconv包函数
//func FormatBool(b bool) string
//func FormatFloat(f float64,fmt byte,prec,bitSize int) string
//func FormatInt(i int64, base int) string
//func FormatUint(i uint64, base int) string
//string>>基本数据类型
//strconv包函数
//func ParseBool(str string)(value bool,err error)
//func ParseFloat(s string, bitSize int)(f float64,err error)
//func ParseInt(s string, base int, bitSize int)(i int64, err error)
//func ParseUnit(s string, b int, bitSize int)(n uint64, err error)
//转 int32 float32  int32() float32()
//注意事项  确保string类型能够转成有效数据类型

func main() {
	var i int = 42
	var f float64 = float64(i)
	var u uint8 = uint8(f)
	//fmt.Printf(i, f, u) //cannot use i (type int) as type string in argument to fmt.Printf
	fmt.Println(i, f, u)

	var i32 int32 = 100
	//i => float
	var n1 float32 = float32(i32)
	var n2 int8 = int8(i32)
	var n3 int64 = int64(i32) //低精度>>高精度
	fmt.Printf("i32=%v n1=%v n2=%v n3=%v\n", i32, n1, n2, n3)

	//2 被转换的是变量存储的数据（值），变量本身的数据类型没有变化
	fmt.Printf("i32 type is %T\n", i32) //int32

	//3 int64转换int8，编译不会报错，转换结果是按溢出处理，可能和希望不一样
	var num1 int64 = 999999
	var num2 int8 = int8(num1)
	fmt.Println("num2=", num2)

	//基本数据类型 转 string
	var nm1 int = 99
	var nm2 float64 = 23.456
	var b bool = true
	var myChar byte = 'h'
	var str string //空的str
	//使用fmt.Sprintf方法
	str = fmt.Sprintf("%d", nm1)
	fmt.Printf("str type %T str=%q\n", str, str)

	str = fmt.Sprintf("%f", nm2)
	fmt.Printf("str type %T str=%q\n", str, str)

	str = fmt.Sprintf("%t", b)
	fmt.Printf("str type %T str=%q\n", str, str)

	str = fmt.Sprintf("%c", myChar)
	fmt.Printf("str type %T str=%q\n", str, str)

	//strconv
	var nm3 int = 99
	var nm4 float64 = 23.456
	var b1 bool = true

	str = strconv.FormatInt(int64(nm3), 10)
	fmt.Printf("str type %T str=%q\n", str, str)

	//strconv.FormatFloat(nm4, 'f', 10, 64)
	//说明：'f'格式 10：表示小数位保留10位 64：表示这个小数是float64
	str = strconv.FormatFloat(nm4, 'f', 10, 64)
	fmt.Printf("str type %T str=%q\n", str, str)

	str = strconv.FormatBool(b1)
	fmt.Printf("str type %T str=%q\n", str, str)

	//strconv Itoa
	var nm5 int64 = 4567
	str = strconv.Itoa(int(nm5))
	fmt.Printf("str type %T str=%q\n", str, str)

	//string 转基本数据类型
	var str1 string = "true"
	var b2 bool
	//b2,_ = strconv.ParseBool(str1)
	//说明
	//1 strconv.ParseBool(str) 函数会返回两个值(value bool, err error)
	//2 因为我只想获取到value bool，不想获取err所以用_忽略
	b2, _ = strconv.ParseBool(str1)
	fmt.Printf("b2 type %T b2=%v\n", b2, b2)

	var str2 string = "1234590"
	var in1 int64
	var in2 int
	in1, _ = strconv.ParseInt(str2, 10, 64)
	in2 = int(in1)
	fmt.Printf("in1 type %T in1=%v\n", in1, in1)
	fmt.Printf("in2 type %T in2=%v\n", in2, in2)

	var str3 string = "123.456"
	var f1 float64
	f1, _ = strconv.ParseFloat(str3, 64)
	fmt.Printf("f1 type %T f1=%v\n", f1, f1)

	//注意 确保有效 否则为0
	var str4 string = "hello"
	var in3 int64 = 11
	in3, _ = strconv.ParseInt(str4, 10, 64)
	fmt.Printf("in3 type %T in3=%v\n", in3, in3)
}
