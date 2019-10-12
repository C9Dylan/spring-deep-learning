package cn.springscloud.springdeeplearning.ioc.aware;

import cn.springscloud.springdeeplearning.ioc.aware.utils.SpringAwareComponentUtils;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

/**
 * Created by Kim QQ.Cong on 2019-09-03 / 15:56
 *
 * @author: CongQingquan
 * @Description:
 */
public class AwareInterfaceTest {

    @Test
    public void test() {
        /**
         * 常用的Aware接口:
         *
         * 1. ApplicationContextAware: 获取上下文容器
         *
         * 2. BeanFactoryAware: Bean Factory
         *
         * 3. BeanClassLoaderAware: 获取加载Bean的类加载器
         *
         * 4. EnvironmentAware: 上下文环境变量
         *
         * 5. EmbeddedValueResolverAware: String解析器
         *
         * 6. ResourceLoaderAware: 资源文件加载器
         *
         * 7. BeanNameAware: 获取Bean名称
         */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareTestConfiguration.class);

        SpringAwareComponentUtils springAwareComponentUtils = context.getBean(SpringAwareComponentUtils.class);

        // 1. ApplicationContext
        ApplicationContext applicationContext = springAwareComponentUtils.getApplicationContext();
        System.out.println(applicationContext);

        // 2. ClassLoader
        ClassLoader beanClassLoader = springAwareComponentUtils.getBeanClassLoader();
        System.out.println(beanClassLoader);

        // 3. BeanFactory
        BeanFactory beanFactory = springAwareComponentUtils.getBeanFactory();
        System.out.println(beanFactory);

        // 4. Environment
        Environment environment = springAwareComponentUtils.getEnvironment();
        System.out.println(environment);

        // 5. Resource loader
        ResourceLoader resourceLoader = springAwareComponentUtils.getResourceLoader();
        System.out.println(resourceLoader);

        // 6. String resolver
        StringValueResolver stringValueResolver = springAwareComponentUtils
            .getStringValueResolver();
        System.out.println(stringValueResolver);
    }
}