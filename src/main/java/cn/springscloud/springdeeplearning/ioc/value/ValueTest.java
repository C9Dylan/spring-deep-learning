package cn.springscloud.springdeeplearning.ioc.value;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

/**
 * Created by Kim QQ.Cong on 2019-08-30 / 17:05
 *
 * @author: CongQingquan
 * @Description: value 测试
 */
public class ValueTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            ValueTestConfiguration.class);

        ApplicationInfo applicationInfo = context.getBean(ApplicationInfo.class);
        System.out.println(applicationInfo);

        ConfigurableEnvironment environment = context.getEnvironment();
        String projectName = environment.getProperty("project.name");
        String serverPort = environment.getProperty("server.port");
        System.out.println(projectName);
        System.out.println(serverPort);
    }
}