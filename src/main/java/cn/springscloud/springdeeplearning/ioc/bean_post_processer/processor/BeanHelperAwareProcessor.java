package cn.springscloud.springdeeplearning.ioc.bean_post_processer.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by Kim QQ.Cong on 2019-09-02 / 14:25
 *
 * @author: CongQingquan
 * @Description: BeanHelperAwareProcessor
 */
public class BeanHelperAwareProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
        throws BeansException {
        if (bean instanceof BeanHelperAware) {
            ((BeanHelperAware) bean).setBeanHelper(new SearchUpdateFieldHelper());
        }
        return bean;
    }
}