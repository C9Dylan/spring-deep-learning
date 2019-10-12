package cn.springscloud.springdeeplearning.ioc.init_destroy.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by Kim QQ.Cong on 2019-08-30 / 18:08
 *
 * @author: CongQingquan
 * @Description:
 */
public class Yingyingying implements InitializingBean, DisposableBean {

    public Yingyingying() {
        System.out.println("construct method execute");
    }

    /**
     * order:
     *  1. JSR250
     *  2. Init & Destroy interface
     *  3. @Bean
     */

    /**
     * First way: @Bean:  initMethod & destroyMethod property
     */
    public void initMethod() {
        System.out.println("@Bean: init method execute");
    }

    public void destroyMethod() {
        System.out.println("@Bean: destroy method execute");
    }

    /**
     * Second way: implement InitializingBean interface &
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean interface: init method execute");
    }

    @Override
    public void destroy() {
        System.out.println("DisposableBean interface: destroy method execute");
    }

    /**
     * Third way: JSR250 -> @PostConstruct & @PreDestroy
     */
    @PostConstruct
    public void postConstructMethod() {
        System.out.println("JSR250: init method execute");
    }

    @PreDestroy
    public void preDestroyMethod() {
        System.out.println("JSR250: destroy method execute");
    }
}