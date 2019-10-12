package cn.springscloud.springdeeplearning.ioc.init_destroy;

import cn.springscloud.springdeeplearning.ioc.init_destroy.bean.Yingyingying;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Kim QQ.Cong on 2019-08-30 / 18:09
 *
 * @author: CongQingquan
 * @Description:
 */
@Configuration
public class InitDestroyConfiguration {

    @Bean(
        initMethod = "initMethod",
        destroyMethod = "destroyMethod"
    )
    public Yingyingying yingyingying() {
        return new Yingyingying();
    }
}