package cn.springscloud.springdeeplearning.ioc.bean_post_processer.processor;

/**
 * Created by Kim QQ.Cong on 2019-09-02 / 14:21
 *
 * @author: CongQingquan
 * @Description:
 */
public interface BeanHelperAware {

    /**
     * 赋值BeanHelper
     * @param beanHelper
     */
    void setBeanHelper(BeanHelper beanHelper);
}