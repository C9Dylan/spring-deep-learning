package cn.springscloud.springdeeplearning.aop;

import cn.springscloud.springdeeplearning.aop.bean.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Kim QQ.Cong on 2019-09-04 / 10:54
 *
 * @author: CongQingquan
 * @Description:
 */
@Configuration
@EnableAspectJAutoProxy
public class AopTestConfiguration {

    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }

    @Bean
    public LoggerAspect loggerAspect() {
        return new LoggerAspect();
    }
}