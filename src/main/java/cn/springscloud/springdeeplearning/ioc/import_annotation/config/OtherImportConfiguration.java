package cn.springscloud.springdeeplearning.ioc.import_annotation.config;

import cn.springscloud.springdeeplearning.ioc.import_annotation.bean.Purple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Kim QQ.Cong on 2019-08-30 / 17:07
 *
 * @author: CongQingquan
 * @Description:
 */
@Configuration
public class OtherImportConfiguration {

    @Bean
    public Purple purple() {
        return new Purple();
    }
}