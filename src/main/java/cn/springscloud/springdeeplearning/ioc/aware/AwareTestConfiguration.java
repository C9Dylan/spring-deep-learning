package cn.springscloud.springdeeplearning.ioc.aware;

import cn.springscloud.springdeeplearning.ioc.aware.utils.SpringAwareComponentUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Kim QQ.Cong on 2019-09-03 / 16:29
 *
 * @author: CongQingquan
 * @Description:
 */
@Configuration
public class AwareTestConfiguration {
    @Bean
    public SpringAwareComponentUtils springAwareComponentUtils() {
        return new SpringAwareComponentUtils();
    }
}