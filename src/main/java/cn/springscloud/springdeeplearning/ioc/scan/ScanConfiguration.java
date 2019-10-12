package cn.springscloud.springdeeplearning.ioc.scan;

import cn.springscloud.springdeeplearning.ioc.scan.bean.custom.Kent;
import cn.springscloud.springdeeplearning.ioc.scan.custom.CustomCondition;
import cn.springscloud.springdeeplearning.ioc.scan.custom.CustomScanFilter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by Kim QQ.Cong on 2019-08-30 / 14:15
 *
 * @author: CongQingquan
 * @Description:
 */
@ComponentScan(
    value = {"cn.springscloud.springdeeplearning.ioc.scan.bean"},
    excludeFilters = {
        @Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
        // 自定义过滤逻辑
        @Filter(type = FilterType.CUSTOM, classes = {CustomScanFilter.class})
    }
)
@Configuration
public class ScanConfiguration {

    @Bean
    @Lazy
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    // @Conditional 放在类上是说明只有条件通过后, 才会读取被标注的配置. 方法上则说明符合条件后注入Bean.
    @Conditional(value = {CustomCondition.class})
    public Kent kent() {
        return new Kent();
    }
}