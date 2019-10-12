package cn.springscloud.springdeeplearning.ioc.bean_post_processer.util;

import cn.springscloud.springdeeplearning.ioc.bean_post_processer.processor.BeanHelper;
import cn.springscloud.springdeeplearning.ioc.bean_post_processer.processor.BeanHelperAware;
import java.util.Map;
import org.springframework.beans.factory.BeanNameAware;

/**
 * Created by Kim QQ.Cong on 2019-09-02 / 14:41
 *
 * @author: CongQingquan
 * @Description:
 */
public class MyBeanHelper implements BeanHelperAware, BeanNameAware {

    private BeanHelper beanHelper;

    private String beanName;

    @Override
    public void setBeanHelper(BeanHelper beanHelper) {
        this.beanHelper = beanHelper;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    /**
     * 将JavaBean实体内的字段组装成Key/Value结构
     */
    public Map<String, Object> properties2Map(Object bean) {
        return beanHelper.properties2Map(bean);
    }
}