package org.djx.think.in.spring.ioc.overview.dependency.injection;

import org.djx.think.in.spring.ioc.overview.annotation.Super;
import org.djx.think.in.spring.ioc.overview.domain.User;
import org.djx.think.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * 依赖查找示例
 *
 * @author dong jing xi
 * @date 2020/6/17 0:32
 **/
public class DependencyInjectionDemo {

    public static void main(String[] args) {

        // 配置 Xml 文件
        // 启动 Spring 应用上下文
      // BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INFO/dependency-injection-context.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INFO/dependency-injection-context.xml");

        // 来源依赖一： 自定义bean
        UserRepository userRepository = applicationContext.getBean("userRepository", UserRepository.class);
        System.out.println(userRepository.getUsers());

        // 依赖查找
        //  System.out.println(beanFactory.getBean(BeanFactory.class));

        // 依赖来源二： 依赖注入（容器内建依赖）
        System.out.println(userRepository.getBeanFactory());

        System.out.println(userRepository.getBeanFactory() == applicationContext);

        System.out.println(userRepository.getApplicationContextObjectFactory().getObject());

        System.out.println(userRepository.getApplicationContextObjectFactory().getObject() == applicationContext);


        // 依赖来源三： 容器内建 bean
        Environment environment = applicationContext.getBean(Environment.class);
        System.out.println(environment);
    }


}
