package cn.springscloud.springdeeplearning.ioc.scan.custom;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by Kim QQ.Cong on 2019-08-30 / 16:08
 *
 * @author: CongQingquan
 * @Description: 自定义注入条件
 *
 * 1. 实现Condition接口 2. matches 函数内编写注入条件逻辑(true为匹配, 则不会注入)
 */
public class CustomCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // Do nothing
        return false;
    }
}