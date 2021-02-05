package com.macrodream.serverless.kotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class KotlinApp {
    //Kotlin Lambda support
    @Bean
    open fun kotlinSupplier(): () -> String {
        return  { "Hello from Kotlin" }
    }

    @Bean
    open fun kotlinFunction(): (String) -> String {
        return  { it.toUpperCase() }
    }

    @Bean
    open fun kotlinConsumer(): (String) -> Unit {
        return  { println(it) }
    }
}
//Kotlin 可以运行
fun main(args: Array<String>){
    SpringApplication.run(KotlinApp::class.java,*args)
}