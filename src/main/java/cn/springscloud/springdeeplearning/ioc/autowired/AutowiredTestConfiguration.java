package cn.springscloud.springdeeplearning.ioc.autowired;

import cn.springscloud.springdeeplearning.ioc.autowired.autowired_bean.AutowiredTestService;
import cn.springscloud.springdeeplearning.ioc.autowired.autowired_bean.AutowiredTestServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Kim QQ.Cong on 2019-09-02 / 16:46
 *
 * @author: CongQingquan
 * @Description:
 */
@ComponentScan({
    "cn.springscloud.springdeeplearning.ioc.autowired.autowired_bean",
    "cn.springscloud.springdeeplearning.ioc.autowired.resource_inject_bean",
    "cn.springscloud.springdeeplearning.ioc.autowired.autowired_annotation_test_bean"
})
@Configuration
public class AutowiredTestConfiguration {

    @Bean("autowiredTestServiceImpl2")
    public AutowiredTestService autowiredTestService() {
        AutowiredTestServiceImpl autowiredTestService = new AutowiredTestServiceImpl();
        autowiredTestService.setLevel(2);
        return autowiredTestService;
    }
}