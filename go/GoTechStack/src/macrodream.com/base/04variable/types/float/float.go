package main

import "fmt"

//小数类型/浮点型
//浮点类型
//类型			占用存储空间		表数范围
//单精度float32	4字节			-3.403E38~3.403E38
//双精度float64	8字节			-1.798E308~1.798E308
//说明
//1浮点数机器中存放形式：浮点数=符号位+指数位+尾数位
//3.56
//2尾数部分可能丢失，造成精度损失。 -123.0000901
//3浮点型存储分为3部分：符号位+指数位+尾数位  存储过程中，精度会有丢失

func main() {
	var price float32 = 89.12
	fmt.Println("price=", price)

	//浮点数都是有符号的
	var num1 float32 = -0.00089
	var num2 float64 = -7809656.09
	fmt.Println("num1=", num1, "num2=", num2)

	//精度损失 ， float64 比 float32 精确
	var num3 float32 = -123.0000901
	var num4 float64 = -123.0000901
	fmt.Println("num3=", num3, "num4=", num4)

	//浮点型使用细节
	//	1有固定范围和字段长度，不受具体OS影响
	//	2默认声明位float64类型
	var num5 = 1.1
	fmt.Printf("num5的数据类型是 %T \n", num5)
	//	3浮点型常量2种表示形式
	//		十进制数形式： 5.12 	.512 (必须有小数点)
	num6 := 5.12
	num7 := .123 //=> 0.123
	fmt.Println("num6=", num6, "num7=", num7)
	//		科学计数法形式：	5.123e2 = 5.12 * 10的2次方  5.12E-2 = 5.12/10的2次方
	num8 := 5.1234e2
	num9 := 5.1234e2
	num10 := 5.1234e-2
	fmt.Println("num8=", num8, "num9=", num9, "num10=", num10)
	//	4通常，应该使用float64，因为它比float32更精确
}
