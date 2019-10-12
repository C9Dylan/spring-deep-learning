package cn.springscloud.springdeeplearning.ioc.bean_post_processer.processor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Kim QQ.Cong on 2019-07-26 / 15:14
 *
 * @author: CongQingquan
 * @Description: 忽略检查标记注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreCheck {

}
