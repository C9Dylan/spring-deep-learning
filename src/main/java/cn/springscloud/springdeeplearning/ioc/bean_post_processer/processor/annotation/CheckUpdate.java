package cn.springscloud.springdeeplearning.ioc.bean_post_processer.processor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Kim QQ.Cong on 2019-09-02 / 14:32:00
 *
 * @author: CongQingquan
 * @Description: 检查是否更新的标记注解
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckUpdate {

}
