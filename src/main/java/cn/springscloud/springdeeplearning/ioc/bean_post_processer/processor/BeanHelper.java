package cn.springscloud.springdeeplearning.ioc.bean_post_processer.processor;

import java.util.Map;

/**
 * Created by Kim QQ.Cong on 2019-09-02 / 14:22
 *
 * @author: CongQingquan
 * @Description:
 */
public interface BeanHelper {

    /**
     * 对比查询不同字段值后封装到Map中返回
     */
    Map<String, Object[]> searchDifferentFieldValue(Object sourceObj, Object updateObj);

    /**
     * 将JavaBean实体内的字段组装成Key/Value结构
     */
    Map<String, Object> properties2Map(Object bean);
}