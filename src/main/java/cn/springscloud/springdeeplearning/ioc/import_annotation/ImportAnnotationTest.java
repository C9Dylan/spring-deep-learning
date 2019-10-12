package cn.springscloud.springdeeplearning.ioc.import_annotation;

import cn.springscloud.springdeeplearning.ioc.import_annotation.config.ImportTestConfiguration;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Kim QQ.Cong on 2019-08-30 / 17:05
 *
 * @author: CongQingquan
 * @Description: @Import 注解测试类
 */
public class ImportAnnotationTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            ImportTestConfiguration.class);

        // 1. 测试@Import导入bean
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanDefinitionName = beanDefinitionNames[i];
            BeanDefinition beanDefinition = context.getBeanDefinition(beanDefinitionName);
            System.out.println("name -> " + beanDefinitionName +
                ", scope ->" + beanDefinition.getScope() +
                ", lazy load -> " + beanDefinition.isLazyInit());
        }
    }
}