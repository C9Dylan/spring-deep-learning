package cn.springscloud.springdeeplearning.ioc.profile;

import java.util.stream.Stream;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Kim QQ.Cong on 2019-09-03 / 17:01
 *
 * @author: CongQingquan
 * @Description:
 */
public class ProfileTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ProfileTestConfiguration.class);
        context.getEnvironment().setActiveProfiles(
            "test", "dev"
        );
        context.refresh();
        context.start();

        Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);

        /**
         * Profile 注解:
         *
         * 根据profile的配置, 生效一些对应配置.
         *
         * 加载类上: 判断当起环境是否为@Profile中的标示环境, 是则加载该类, 否则忽略.
         *
         * 加载函数上: 判断当起环境是否为@Profile中的标示环境, 是则加载该类, 否则忽略.
         */
    }
}