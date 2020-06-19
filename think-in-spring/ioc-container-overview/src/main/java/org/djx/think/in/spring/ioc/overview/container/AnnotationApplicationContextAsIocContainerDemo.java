package org.djx.think.in.spring.ioc.overview.container;

import org.djx.think.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Ioc 容器示例
 * 使用beanFactory作为Ioc容器
 *
 * @author dong jing xi
 * @date 2020/6/18 0:59
 **/
@Configuration
public class AnnotationApplicationContextAsIocContainerDemo {

    @Bean
    public User user() {
        User user = new User();
        user.setId(1);
        user.setName("djx");
        return user;
    }

    public static void main(String[] args) {
        // 创建容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将AnnotationApplicationContextAsIocContainerDemo作为配置类
        applicationContext.register(AnnotationApplicationContextAsIocContainerDemo.class);
        // 启动applicationContext容器
        applicationContext.refresh();
        // 获取容器中的bean
        lookupCollectionByType(applicationContext);
        // 关闭容器
        applicationContext.close();
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            Map<String, User> users = ((ListableBeanFactory) beanFactory).getBeansOfType(User.class);
            System.out.println("获取集合对象" + users);
        }
    }

}
