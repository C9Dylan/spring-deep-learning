package cn.springscloud.springdeeplearning.ioc.value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Kim QQ.Cong on 2019-09-02 / 16:46
 *
 * @author: CongQingquan
 * @Description:
 */
@PropertySource({
    "classpath:application.properties",
    "classpath:application_info.properties"
})
@Configuration
public class ValueTestConfiguration {
    @Bean
    public ApplicationInfo applicationInfo() {
        return new ApplicationInfo();
    }
}