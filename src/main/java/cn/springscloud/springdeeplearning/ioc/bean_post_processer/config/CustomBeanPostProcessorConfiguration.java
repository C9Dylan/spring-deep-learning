package cn.springscloud.springdeeplearning.ioc.bean_post_processer.config;

import cn.springscloud.springdeeplearning.ioc.bean_post_processer.processor.BeanHelperAwareProcessor;
import cn.springscloud.springdeeplearning.ioc.bean_post_processer.util.MyBeanHelper;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * Created by Kim QQ.Cong on 2019-09-02 / 15:05:58
 *
 * @author: CongQingquan
 * @Description: 自定义BeanPost后置处理器配置文件
 */
@ComponentScan(
    value = {"cn.springscloud.springdeeplearning.ioc.bean_post_processer"}
)
@Configuration
public class CustomBeanPostProcessorConfiguration {

    @Bean
    public MyBeanHelper myBeanHelper() {
        return new MyBeanHelper();
    }

    @Bean
    public BeanPostProcessor beanHelperAwareProcessor() {
        return new BeanHelperAwareProcessor();
    }
}