package cn.springscloud.springdeeplearning.ioc.autowired.autowired_annotation_test_bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Kim QQ.Cong on 2019-09-03 / 14:22
 *
 * @author: CongQingquan
 * @Description: 测试@Autowired注解的Bean
 */
@Component
public class Cqq {

    /**
     * 2. 属性: 类型适配, 或根据名称适配(@Autowired, @Qualifier, @Resource, @Inject)
     */
    @Autowired
    private Car car;

    private Yihang yihang;

    /**
     * 1. 构造器(构造函数中的参数无需使用@Autowired注入, IOC会根据类型自动适配).
     *      1.1 默认使用无参构造(Reflection: newInstance())
     *      1.2 如果没有无参构造函数则调用唯一的有参构造
     *      1.3 若存有多个有参构造且都没有标注@Autowired, 则抛出异常, 因为无法得知要使用哪个有参构造进行实例化Bean.
     *      1.4 若存有多个有参构造, 必须有一个且仅仅一个构造函数标注@Autowired, 告知IOC使用哪个构造函数进行实例化Bean. 若多个有参构造同时标注@Autowired则抛出异常
     */
//    public Cqq() {
//        System.out.println("No arguments construct method...");
//    }

    public Cqq(Car car) {
        System.out.println("Car arguments construct method...");
    }

    @Autowired
    public Cqq(Car car, @Autowired Yihang yihang) {
        System.out.println("All arguments construct method...");
        this.car = car;
        this.yihang = yihang;
    }

    /**
     * 3. 普通函数: 执行所有标注了@Autowired注解的函数(函数中的参数无需使用@Autowired注入, IOC会根据类型自动适配)
     */
    @Autowired
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Cqq{" +
            "car=" + car +
            ", yihang=" + yihang +
            '}';
    }
}