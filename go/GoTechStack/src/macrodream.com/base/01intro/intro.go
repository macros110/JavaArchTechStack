package main //一个go文件需要在一个包

import "fmt"

//package expected, got 'func'

/**
Golang学习方向
	区块链研发工程师
	Go服务器端/游戏软件工程师
	Golang分布式/云计算软件工程师
Golang应用领域
	区块链技术 Blockchain Technology  BT
		分布式账本技术，互联网数据库技术，去中心化、公开透明、每个人均可参与
	后端服务器应用
		美团后台流量支撑程序
			排序、推荐、搜索、负载均衡、cache、容错、按条件分流、运行指标（qps、latency）
		仙侠道
			通讯、逻辑、数据存储
	云计算/云服务后台应用
		盛大云CDN（内容分发网络）
		京东消息推送云服务/京东分布式文件系统
Golang吉祥物	金花鼠 🐿️ Gordon（创始人之一）
Golang学习方法
	1高效而愉快的学习
	2先建立一个整体框架，然后学习细节
	3在实际工作中，要培养用到什么，能够快速学习什么能力
	4先know how，再know why 工科
	5软件编程是一门"做中学"学科，不是会了再做，而是做了才会
	6适当囫囵吞枣
	7学习软件编程是再琢磨别人怎么做，而不是我认为应该怎么做的过程
快速深入学习一个新技术和知识点
	1发现问题
		如 页面局部刷新问题
		跳槽 学习新技术
	2现有技术和新技术能否解决问题
		2-1 使用传统iframe，可以解决，但不够好
		2-2 使用新技术ajax
	3学习新技术/知识点 原理 和 基本语法
	4快速入门案例
		简单
		了解基本使用
	4讨论新技术/知识点细节（回归问题）
		怎么使用更规范
		使用陷阱
		注意什么
Why is Go语言？
	Go语言 区块链主流语言
	最具发展潜力语言
Go核心开发 Ken Thompson（Unix，B，C）、Rob Pike（Unix团队，UTF-8）、Robert Griesemer（HotSpot、V8）
Go解决但问题
	硬件技术更新频繁，主流语言发展落后硬件，不能合理利用多核多CPU优势提升软件系统性能
	缺乏一个简洁高效但编程语言，1风格不统一，2计算力不够，3处理大并发不够好
	c/c++运行速度快但编译速度很慢，还存在内存泄漏等一系列困扰
Go语言特点
	Go = C + Python 静态编译语言等安全和性能，动态语言开发维护高效率
	1从C继承了 表达式语法、控制结构、基础数据类型、调用参数传值、指针等 编译执行方式及弱化指针
	2引入包的概念，组织程序结构，一个文件归属一个包，不能单独存在
	3垃圾回收机制，内存自动回收，不需要开发人员管理
	4天然并发，
		语言层面支持并发实现简单，
		goroutine轻量级线程可实现大并发处理高效利用多核，
		CPS（Communicating Sequential Processes）并发模型实现
	5吸收管道通讯机制，通过管道channel实现不同goroute之间的相互通信
	6函数返回多个值
	7新的创新，如切片、延时执行defer等
*/

func sayOK() {
	//输出一句话
	fmt.Println("OK")
}
func main() {
	sayOK()
	sum, sub := getSumAndSub(30, 31)
	fmt.Println("sum=", sum, "sub=", sub)
	sum2, _ := getSumAndSub(10, 20)
	fmt.Println("sum=", sum2)
}

//写一个函数，实现同时返回和，差
func getSumAndSub(n1 int, n2 int) (int, int) {
	sum := n1 + n2
	sub := n1 - n2
	return sum, sub
}
