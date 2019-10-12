package cn.springscloud.springdeeplearning.ioc.import_annotation.custom;

import cn.springscloud.springdeeplearning.ioc.import_annotation.bean.Rainbow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by Kim QQ.Cong on 2019-08-30 / 17:31
 *
 * @author: CongQingquan
 * @Description: 自定义导入BeanDefinition
 *
 * 1. 实现ImportBeanDefinitionRegistrar接口 2. 与ImportSelector不同, 该接口会直接将BeanDefinitionRegister交给你,
 * 自由度更高
 */
public class CustomImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
        BeanDefinitionRegistry registry) {

        boolean containPurple = registry.containsBeanDefinition("purple");
        boolean containRed = registry.containsBeanDefinition(
            "cn.springscloud.springdeeplearning.ioc.import_annotation.bean.Red");
        if (containPurple && containRed) {
            registry.registerBeanDefinition("rainbow", new RootBeanDefinition(Rainbow.class));
        }
    }
}