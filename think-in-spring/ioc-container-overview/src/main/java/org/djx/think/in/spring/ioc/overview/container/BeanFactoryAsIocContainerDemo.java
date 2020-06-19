package org.djx.think.in.spring.ioc.overview.container;

import org.djx.think.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * Ioc 容器示例
 * 使用beanFactory作为Ioc容器
 *
 * @author dong jing xi
 * @date 2020/6/18 0:59
 **/
public class BeanFactoryAsIocContainerDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INFO/dependency-lookup-context.xml";
        int beanCounts = reader.loadBeanDefinitions(location);
        System.out.println("bean 定义加载数量" + beanCounts);

        lookupCollectionByType(beanFactory);
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            Map<String, User> users = ((ListableBeanFactory) beanFactory).getBeansOfType(User.class);
            System.out.println("获取集合对象" + users);
        }
    }

}
