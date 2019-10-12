package cn.springscloud.springdeeplearning.ioc.aware.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

/**
 * Created by Kim QQ.Cong on 2019-09-03 / 15:58
 *
 * @author: CongQingquan
 * @Description: Spring 提供的Aware类别组件
 */
public class SpringAwareComponentUtils implements ApplicationContextAware, BeanFactoryAware,
    BeanClassLoaderAware, EnvironmentAware, EmbeddedValueResolverAware, ResourceLoaderAware {

    /**
     * 1. 容器上下文
     */
    private ApplicationContext applicationContext;

    /**
     * 2. Bean Factory
     */
    private BeanFactory beanFactory;

    /**
     * 3. Bean类加载器
     */
    private ClassLoader beanClassLoader;

    /**
     * 4. String解析器
     */
    private StringValueResolver stringValueResolver;

    /**
     * 5. 上下文环境变量
     */
    private Environment environment;

    /**
     * 6. 资源文件加载器
     */
    private ResourceLoader resourceLoader;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.beanClassLoader = classLoader;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.stringValueResolver = stringValueResolver;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * ========== Getter ==========
     */

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public ClassLoader getBeanClassLoader() {
        return beanClassLoader;
    }

    public StringValueResolver getStringValueResolver() {
        return stringValueResolver;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}