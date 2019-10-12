package cn.springscloud.springdeeplearning.ioc.autowired;

import cn.springscloud.springdeeplearning.ioc.autowired.autowired_annotation_test_bean.Cqq;
import cn.springscloud.springdeeplearning.ioc.autowired.autowired_bean.AutowiredTestController;
import cn.springscloud.springdeeplearning.ioc.autowired.autowired_bean.AutowiredTestService;
import cn.springscloud.springdeeplearning.ioc.autowired.resource_inject_bean.InjectTestController;
import cn.springscloud.springdeeplearning.ioc.autowired.resource_inject_bean.ResourceTestController;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Kim QQ.Cong on 2019-08-30 / 17:05
 *
 * @author: CongQingquan
 * @Description: Autowired 测试
 */
public class AutowiredTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            AutowiredTestConfiguration.class);

        // 测试自动适配

        // 当一个接口存有两个实现Bean时, spring无法断定使用哪个.
        // 解决方式有两种:
        // 1. @Primary, 标注为更高的优先级, spring就会根据此注解进行注入
        // 2. @Qualifier, 显示声明注入的bean的名称, 且必须与@Autowired配合使用, 单独使用不生效

        // 1. 测试 @Primary
        AutowiredTestService autowiredTestService = context.getBean(AutowiredTestService.class);
        System.out.println(autowiredTestService);

        // 2. 测试 @Qualifier
        AutowiredTestController autowiredTestController = context.getBean(AutowiredTestController.class);
        autowiredTestController.print();

        // 3. 测试@Resource(JSR-250) @Inject(JSR-330)
        //    JSR: java规范
        InjectTestController injectTestController = context.getBean(InjectTestController.class);
        System.out.println(injectTestController.resourceInjectTestService);
        ResourceTestController resourceTestController = context.getBean(ResourceTestController.class);
        System.out.println(resourceTestController.resourceInjectTestService);

        // 测试 @Autowired 注解分别标注在: 属性, 构造函数, 普通函数, 参数

        // 注入顺序:
        //      1. 构造器(构造函数中的参数无需使用@Autowired注入, IOC会根据类型自动适配).
        //      1.1 默认使用无参构造(Reflection: newInstance())
        //      1.2 如果没有无参构造函数则调用唯一的有参构造
        //      1.3 若存有多个有参构造且都没有标注@Autowired, 则抛出异常, 因为无法得知要使用哪个有参构造进行实例化Bean.
        //      1.4 若存有多个有参构造, 必须有一个且仅仅一个构造函数标注@Autowired, 告知IOC使用哪个构造函数进行实例化Bean. 若多个有参构造同时标注@Autowired则抛出异常

        //      2. 属性: 类型适配, 或根据名称适配(@Autowired, @Qualifier, @Resource, @Inject)

        //      3. 普通函数: 执行所有标注了@Autowired注解的函数(函数中的参数无需使用@Autowired注入, IOC会根据类型自动适配)

        //      4. 参数: 加与不加都无关紧要, IOC会自动适配. 一般在@Bean函数中, 即注入配置Bean时常用到这个适配点.

        Cqq cqq = context.getBean(Cqq.class);
        System.out.println(cqq);
    }
}