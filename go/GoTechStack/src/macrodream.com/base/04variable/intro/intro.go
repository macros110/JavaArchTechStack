package main

import "fmt"

//变量概念
//变量相当于内存中的一个数据存储空间的表示，可看作房间门牌号，通过门牌号找到房间，同理通过变量名访问道变量值。
//变量使用步骤
//声明变量（定义变量）
//赋值
//使用
//变量使用注意事项
//变量表示内存中一个存储区域
//该区域有自己名称（变量名）和类型（数据类型）
//Golang变量使用三种方式
//指定变量类型，声明后若不赋值，使用默认值 var i int
//根据值自行判断变量类型（类型推导）
//省略var，注意:=左侧变量不应该是已声明过，否则编译错误 num := 10
//多变量声明
//全局变量声明
//该区域的数据值可以在同一类型范围内不断变化
//变量在同一作用域（函数或代码块）内不能重名
//变量=变量名+值+数据类型，变量三要素
//Golang的变量如果没有赋初值，编译器会使用默认值，比如int默认值0，string默认值为空串，小数默认为0
//变量声明、初始化、赋值
//初始化 同时做声明和赋值
// + 号使用
//数值 为 数学计算
//字符串为字符串拼接

//定义全局变量
var ng1 = 100
var ng2 = 200
var nameg = "jack"

//全局变量一次行声明
var (
	ng3    = 300
	ng4    = 400
	nameg2 = "mary"
)

func main() {
	//定义变量
	var i int
	//赋值
	i = 10
	//使用
	fmt.Println("i=", i)
	//Golang变量使用三种方式
	//1指定变量类型，声明后若不赋值，使用默认值 var i int
	var j int
	fmt.Println("j=", j)
	//2根据值自行判断变量类型（类型推导）
	var num = "10.11"
	fmt.Println("num=", num)
	//3省略var，注意:=左侧变量不应该是已声明过，否则编译错误 num := 10
	name := "tom"
	fmt.Println("name=", name)

	//Golang多变量声明
	//一次声明多个同类型变量
	var i1, i2, i3 int
	fmt.Println("i1=", i1, "i2=", i2, "i3=", i3)
	//一次声明多个变量类型推导
	var n1, name1, n3 = 100, "tom", 888
	fmt.Println("n1=", n1, "name1=", name1, "n3=", n3)
	//一次行声明多个变量:=
	n11, name11, n31 := 100, "tom1", 888
	fmt.Println("n11=", n11, "name11=", name11, "n31=", n31)

	//输出全局变量
	fmt.Println("ng1=", ng1, "ng2=", ng2, "nameg=", nameg)
	fmt.Println("ng3=", ng3, "ng4=", ng4, "nameg2=", nameg2)

	//该区域的数据值可以在同一类型范围内不断变化
	var ichange int = 10
	ichange = 30
	ichange = 50
	fmt.Println("ichange=", ichange)
	//int, 原因是不能改变数据类型
	//ichange = 1.2//'1.2' (type untyped float) cannot be represented by the type int

	//变量在同一作用域（函数或代码块）内不能重名
	var irepeat int = 59
	//irepeat := 99 //No new variables on the left side of ':='
	//var irepeat int = 59//'irepeat' redeclared in this block
	fmt.Println("irepeat=", irepeat)

	//变量声明、初始化、赋值
	var ideclare int //声明
	ideclare = 1000  //赋值
	iinit := 2000    //初始化
	fmt.Println("ideclare=", ideclare, "iinit=", iinit)

	//+ 作用
	var ip1 = 10
	var ip2 = 20
	var isum = ip1 + ip2
	fmt.Println("isum=", isum)

	var str1 = "hello"
	var str2 = "world"
	var strjoin = str1 + str2
	fmt.Println("strjoin=", strjoin)
}
