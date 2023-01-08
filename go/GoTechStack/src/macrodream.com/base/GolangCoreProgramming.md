#Go语言核心编程
##1 概述
##2 helloworld
##3 编码风格
##4 变量与类型
###4.1 变量数据类型
###4.8 指针
#### 基本介绍
1. 基本数据类型，变量存的就是值，也叫值类型
2. 获取变量（包括指针）的地址用&，如var num int，num地址 &num
3. 指针类型，变量存一个地址，这个地址指向空间存才是值 var ptr *int = &num
4. 获取指针类型所指向值用*
    ```
    var i int = 10
	//i 的地址 用 &i
	fmt.Println("i的地址：", &i)

	//var ptr *int = &i
	//1 ptr是一个指针变量
	//2 ptr类型是 *int
	//3 ptr值是 &i
	var ptr *int = &i
	fmt.Printf("ptr=%v\n",ptr)
	fmt.Printf("ptr的地址=%v\n", &ptr)
	fmt.Printf("ptr指向的值=%v\n", *ptr)
    ```
####指针使用细节
1. 值类型，都有对应指针类型，*数据类型，如 *int  *float32
2. 值类型包括：基本数据类型 int系统，float系列，bool，string、数组和结构体struct
###4， 值类型与引用类型
####说明
1. 值类型：基本数据类型 int系列 float系列 bool string 数组 结构体struct
2. 引用类型：指针 slice切片 map   管道chan   interface 等都是引用类型
####特点
1. 值类型 变量直接存值 通常在栈区
2. 引用类型 变量存地址 地址指向才是值 通常在堆区分配空间 没有引用任何地址成为垃圾由GC回收
###标识符等命名规范
1. 标识符概念
   1. 变量、方法、函数等命名时使用字符序列
   2. 凡是自己可以起名字等地方都叫标识符
2. 命名规则
   1. 26英文字母大小写,0-9,_ 组成
   2. 数字不可以开头。var num int//ok var 3num int//error
   3. 严格区分大小写
   4. 标识符不能包含空格
   5. 下划线"_"本身在Go中是一个特殊的标识符，称为空标识符。返回任何标识符，值被忽略。仅占位，不能作为标识符使用。
   6. 不能以系统保留关键字作为标识符，比如break，if等
3. 标识符案例
   1. hello //ok
   2. hello12 //ok
   3. 1hello //error ，数字不能开头
   4. h-b //error ，不能使用-
   5. x h // error ，不能含空格
   6. h_4 // ok
   7. _ab //ok
   8. int //ok,建议不要这样使用
   9. float32 //ok，建议不要这样使用
   10. _ //error
   11. Abc //ok
4. 