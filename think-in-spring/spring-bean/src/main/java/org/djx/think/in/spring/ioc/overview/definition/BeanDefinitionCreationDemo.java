package org.djx.think.in.spring.ioc.overview.definition;

import org.djx.think.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author dong jing xi
 * @date 2020/6/18 23:19
 **/
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {

        // 1、通过BeanDefinitionBuilder构造
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder
                .genericBeanDefinition(User.class)
                .addPropertyValue("id", 1)
                .addPropertyValue("name", "djx")
                .getBeanDefinition();

        // 2、 通过AbstractBeanDefinition 创建
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues().add("id", 1)
                .add("name", "djx");
        genericBeanDefinition.setPropertyValues(propertyValues);

    }

}
