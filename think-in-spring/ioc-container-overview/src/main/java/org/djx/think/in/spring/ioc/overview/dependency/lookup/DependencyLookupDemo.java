package org.djx.think.in.spring.ioc.overview.dependency.lookup;

import org.djx.think.in.spring.ioc.overview.annotation.Super;
import org.djx.think.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找示例
 *
 * @author dong jing xi
 * @date 2020/6/17 0:32
 **/
public class DependencyLookupDemo {
    public static void main(String[] args) {

        // 配置 Xml 文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INFO/dependency-lookup-context.xml");

        // 根据bean名称查找
        lookUpInRealTime(beanFactory);
        lookupInLazy(beanFactory);

        // 根据Bean类型查找
        lookupByType(beanFactory);
        // 根据bean类型查找集合（多个）
        lookupCollectionByType(beanFactory);

        // 根据名称和类型查找
        lookupByNameAndType(beanFactory);

        // 根据java注解查找
        lookupByAnnotation(beanFactory);

    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {

        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Object> beansWithAnnotation = listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("根据java注解查找" + beansWithAnnotation);
        }

    }

    private static void lookupByNameAndType(BeanFactory beanFactory) {
        User user = beanFactory.getBean("user", User.class);
        System.out.println("根据名称和类型查找" + user.toString());
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            Map<String, User> users = ((ListableBeanFactory) beanFactory).getBeansOfType(User.class);
            System.out.println("获取集合对象" + users);
        }

    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("根据类型查找：" + user.toString());
    }

    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("lookupInLazy:" + user.toString());
    }

    private static void lookUpInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("lookUpInRealTime:" + user.toString());
    }


}
