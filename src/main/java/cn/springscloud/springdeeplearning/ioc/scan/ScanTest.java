package cn.springscloud.springdeeplearning.ioc.scan;

import cn.springscloud.springdeeplearning.ioc.scan.bean.custom.Kent;
import cn.springscloud.springdeeplearning.ioc.scan.bean.repository.TestRepository;
import cn.springscloud.springdeeplearning.ioc.scan.bean.service.TestService;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Kim QQ.Cong on 2019-08-30 / 14:03
 *
 * @author: CongQingquan
 * @Description: config / configurate / configuration 的区别:
 *
 * 词性: n. config - configuration(配置) vt. configurate (配置...)
 *
 * config 是后来词, 计算机领域常用词. 因为configuration太长了, 故以config来代替.
 */
public class ScanTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            ScanConfiguration.class);

        // 1. 测试@ComponentScan的excludeFilters
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanDefinitionName = beanDefinitionNames[i];
            BeanDefinition beanDefinition = context.getBeanDefinition(beanDefinitionName);
            System.out.println("name -> " + beanDefinitionName +
                ", scope ->" + beanDefinition.getScope() +
                ", lazy load -> " + beanDefinition.isLazyInit());
        }

        // 2. 测试Service与Repository上的@Sope
        Object testRepository1 = context.getBean(TestRepository.class);
        TestRepository testRepository2 = context.getBean(TestRepository.class);
        System.out.println(testRepository1 == testRepository2);

        Object testService1 = context.getBean(TestService.class);
        TestService testService2 = context.getBean(TestService.class);
        System.out.println(testService1 == testService2);

        // 3. 自定义过滤逻辑
        //    未编写

        // 4. 自定义注入条件
        //    未编写, 只是测试返回值为true时不会注入
        Kent kent = context.getBean(Kent.class);
        System.out.println(kent);
    }
}