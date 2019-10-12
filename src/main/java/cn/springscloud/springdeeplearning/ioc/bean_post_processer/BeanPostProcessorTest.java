package cn.springscloud.springdeeplearning.ioc.bean_post_processer;

import cn.springscloud.springdeeplearning.ioc.bean_post_processer.config.CustomBeanPostProcessorConfiguration;
import cn.springscloud.springdeeplearning.ioc.bean_post_processer.model.Person;
import cn.springscloud.springdeeplearning.ioc.bean_post_processer.util.MyBeanHelper;
import java.util.Map;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Kim QQ.Cong on 2019-09-02 / 10:46
 *
 * @author: CongQingquan
 * @Description:
 */
public class BeanPostProcessorTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            CustomBeanPostProcessorConfiguration.class);

        // 1. 获取自定义的BeanHelper
        MyBeanHelper beanHelper = context.getBean(MyBeanHelper.class);

        // 2. 测试
        Map<String, Object> properties2Map = beanHelper.properties2Map(new Person("张三", 20));
        properties2Map.forEach(
            (key, val) -> System.out.println("Field Name: " + key + ", Field Value: " + val));

        // 3. BeanPostProcessor 在Spring内部使用非常的多,
        //
        // 如: Autowired / init | destroy / Aware interface 这些的实现都是通过BeanPostProcessor实现的.
    }
}