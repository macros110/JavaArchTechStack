package com.macrodream.config;

import com.macrodream.aop.LogAspects;
import com.macrodream.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Macros.Zhang
 * @date 7/3/2022 22:07
 *  AOP:
 *      程序运行期间动态的将某段代码切入到指定方法位置进行运行的编程方式；
 *
 *  1 导入 aop模块；Spring AOP  (spring-aspects)
 *  2 定义一个业务逻辑类(MathCalculator) 在业务逻辑运行的时候将日志进行打印(方法之前，方法运行结束，方法出现异常，xxx)
 *  3 定义一个日志切面类(LogAspects): 切面类里面的方法需要动态感知MathCalculator.div运行到哪里然后执行；
 *      通知方法：
 *          前置通知(@Before)： logStart  div运行之前
 *          后置通知(@After)： logEnd    div运行之后
 *          返回通知(@AfterReturning)： logReturn   div正常返回之后运行
 *          异常通知(@AfterThrowing)： logException  div出现异常以后运行
 *          环绕通知(@Around)：动态代理，手动推进目标方法运行(joinPoint.procced())
 *  4 给切面类的目标方法标注何时何地运行(通知注解)；
 *  5 将切面类和业务逻辑类(目标方法所在类)都加入到容器中；
 *  6 必须告诉Spring哪个是切面类(加上一个注解@Aspect)
 *  7 给配置类中加@EnableAspectJAutoProxy，开启基于注解的aop模式
 *      在Spring中很多的 @EnableXXX；
 *
 *  三步：
 *      1 将业务逻辑组件和切面类都加入到容器中；告诉Spring哪个是切面类 （@Aspect）
 *      2 在切面了类上的每一个通知方法都标注通知注解，告诉Spring何时何地运行(切入点表达式)
 *      3 开启基于注解的aop模式@EnableAspectJAutoProxy
 *
 *  AOP原理：【给容器中注册什么组件】
 *      1 @EnableAspectJAutoProxy 是什么
 *          @Import({AspectJAutoProxyRegistrar.class}) 给容器中导入AspectJAutoProxyRegistrar
 *              利用AspectJAutoProxyRegistrar自定义给容器中注册bean;
 *              internalAutoProxyCreator=AnnotationAwareAspectJAutoProxyCreator
 *          给容器中注册一个AnnotationAwareAspectJAutoProxyCreator
 *      2 AnnotationAwareAspectJAutoProxyCreator继承树
 *          AspectJAwareAdvisorAutoProxyCreator (org.springframework.aop.aspectj.autoproxy)
 *              AbstractAdvisorAutoProxyCreator (org.springframework.aop.framework.autoproxy)
 *                  AbstractAutoProxyCreator (org.springframework.aop.framework.autoproxy)
 *                      BeanFactoryAware (org.springframework.beans.factory)
 *                          Aware (org.springframework.beans.factory)
 *                      ProxyProcessorSupport (org.springframework.aop.framework)
 *                          AopInfrastructureBean (org.springframework.aop.framework)
 *                          BeanClassLoaderAware (org.springframework.beans.factory)
 *                              Aware (org.springframework.beans.factory)
 *                          Ordered (org.springframework.core)
 *                          ProxyConfig (org.springframework.aop.framework)
 *                              Object (java.lang)
 *                              Serializable (java.io)
 *                      SmartInstantiationAwareBeanPostProcessor (org.springframework.beans.factory.config)
 *                          InstantiationAwareBeanPostProcessor (org.springframework.beans.factory.config)
 *                              BeanPostProcessor (org.springframework.beans.factory.config)
 *                      关注后置处理器(在bean的初始化完成前后做事情)、自动装配BeanFactory
 *          AbstractAutoProxyCreator.setBeanFactory()
 *          AbstractAutoProxyCreator.有后置处理器的逻辑；
 *          AbstractAdvisorAutoProxyCreator.setBeanFactory() -> initBeanFactory()
 *          AspectJAwareAdvisorAutoProxyCreator.initBeanFactory()
 *      3  流程：
 *          1. 传入配置类，创建ioc容器
 *          2. 注册配置类，调用refresh() 刷新容器；
 *          3. registerBeanPostProcessors(beanFactory); 注册bean的后置处理器来方便拦截 bean
 *              1.. 先获取ioc容器已经定义了的需要创建对象的所有BeanPostProcessor
 *              2.. 给容器中加别的BeanPostProcessor
 *              3.. 优先注册实现了PriorityOrdered接口的BeanPostProcessor；
 *              4.. 再给容器中注册实现了Ordered接口的BeanPostProcessor；
 *              5.. 注册没实现优先级接口的BeanPostProcessor；
 *              6.. 注册BeanPostProcessor，实际上就是创建BeanPostProcessor对象，保存在容器中；
 *                  创建internalAutoProxyCreator的BeanPostProcessor【AspectJAwareAdvisorAutoProxyCreator】
 *                  1... 创建Bean的实例
 *                  2... populateBean; 给bean的各种属性赋值
 *                  3... initializeBean：初始化bean；
 *                      1.... invokeAwareMethods():处理Aware接口的方法回调
 *                      2.... applyBeanPostProcessorsBeforeInitialization():  初始化前
 *                      3.... invokeInitMethods(); 执行自定义的初始化方法
 *                      4.... applyBeanPostProcessorsAfterInitialization();   初始化后
 *                  4... BeanPostProcessor(AnnotationAwareAspectJAutoProxyCreator)创建成功；--> aspectJAutoProxyCreator
 *              7.. 把BeanPostProcessor注册到BeanFactory中；
 *                  beanFactory.addBeanPostProcessor(postProcessor);
 * =============以上是创建和注册AnnotationAwareAspectJAutoProxyCreator的过程=============================
 *              AnnotationAwareAspectJAutoProxyCreator => InstantiationAwareBeanPostProcessor
 *          4. finishBeanFactoryInitialization(beanFactory); 完成BeanFactory初始化工作；创建剩下的单实例Bean
 *              1.. 历遍获取容器中所有的Bean，依次创建对象getBean(beanName);
 *                  getBean-> doGetBean()->getSingleton()->
 *              2.. 创建bean
 *                  【AnnotationAwareAspectJAutoProxyCreator在所有bean创建之前会有一个拦截，InstantiationAwareBeanPostProcessor，会调用】
 *                  1... 先从缓存中获取当前bean，如果能获取到，说明bean是之前被创建过的；直接使用，否则再创建；
 *                      只要创建好的Bean都会被缓存起来
 *                  2... createBean(); 创建bean   AnnotationAwareAspectJAutoProxyCreator 会在任何bean创建之前尝试返回bean的实例
 *                      【BeanPostProcessor是在Bean对象创建完成初始化前后调用的】
 *                      【InstantiationAwareBeanPostProcessor是在创建Bean实例之前先尝试用后置处理器返回对象的】
 *                      1....  resolveBeforeInstantiation(beanName, mbdToUse); 解析BeforeInstantiation
 *                          希望后置处理器在此能返回一个代理对象；如果能返回代理对象就使用，如果不能就继续
 *                          1) 后置处理器先尝试返回对象；
 *                              bean = applyBeanPostProcessorsBeforeInstantiation():
 *                                  拿到所有后置处理器，如果是InstantiationAwareBeanPostProcessor;
 *                                  就执行postProcessorBeforeInstantiation
 *                              if (bean != null) {
 *                                  bean = applyBeanPostProcessorsAfterInitialization()
 *                              }
 *                      2....  doCreateBean(beanName, mbdToUse, args);真正的去创建一个bean实例；同3.6
 *          5. AnnotationAwareAspectJAutoProxyCreator【InstantiationAwareBeanPostProcessor】作用：
 *              1.. 每一个bean创建之前，调用postProcessorBeforeInstantiation();
 *                  关心MathCalculator和LogAspect的创建
 *                  1... 判断当前bean是否在advisedBeans中(保存了所有需要增强bean)
 *                  2... 判断当前bean是否是基础类型的Advice、Pointcut、Advisor、AopInfrastructureBean，
 *                      或者是否是切面(@Aspect)
 *                  3... 是否需要跳过
 *                      1) 获取候选的增强器(切面里面的通知方法)【List<Advisor> candidateAdvisors】
 *                          每一个封装的通知方法的增强器是InstantiationModelAwarePointcutAdvisor
 *                          判断每一个增强器是否是AspectJPointcutAdvisor类型的；返回true
 *                      2) 永远返回false
 *              2.. 创建对象
 *              postProcessorAfterInitialization
 *                  return wrapIfNecessary(bean, beanName, cacheKey);//包装如果需要的情况下
 *                  1... 获取当前bean的所有增强器(通知方法) Object[] specificInterceptors
 *                      1) 找到候选的所有的增强器(找哪些通知方法是需要切入当前bean的方法的)
 *                      2) 获取到能在bean使用的增强器。
 *                      3) 给增强器排序
 *                  2... 保存当前bean的advisedBeans中；
 *                  3... 如果当前bean需要增强，创建当前bean的代理对象；
 *                      1) 获取所有增强器(通知方法)
 *                      2) 保存到proxyFactory
 *                      3) 创建代理对象: Spring自动决定
 *                          JDKDynamicAopProxy(config); jdk动态代理
 *                          ObjenesisCglibAopProxy(config); cglib动态代理；
 *                  4... 给容器中返回当前组件使用cglib增强的代理对象；
 *                  5... 以后容器中获取到的就是这个组件的代理对象，执行目标方法的时候，代理对象就会执行通知方法的流程。
 *               3..
 *
 *
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAop {
    /**
     * 业务逻辑类加入容器中
     * @return
     */
    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }

    /**
     * 切面类加入到容器中
     * @return
     */
    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }
}
