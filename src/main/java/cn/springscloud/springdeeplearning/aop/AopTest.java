package cn.springscloud.springdeeplearning.aop;

import cn.springscloud.springdeeplearning.aop.bean.MathCalculator;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Kim QQ.Cong on 2019-09-04 / 10:54
 *
 * @author: CongQingquan
 * @Description:
 */
public class AopTest {

    @Test
    public void test() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            AopTestConfiguration.class);

        MathCalculator mathCalculator = context.getBean(MathCalculator.class);
        Integer divideResult1 = mathCalculator.divide(1, 1);
        System.out.println(divideResult1);

//        Integer divideResult2 = mathCalculator.divide(1, 0);
//        System.out.println(divideResult2);
    }
}