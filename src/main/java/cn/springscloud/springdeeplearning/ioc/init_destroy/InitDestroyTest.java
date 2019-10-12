package cn.springscloud.springdeeplearning.ioc.init_destroy;

import cn.springscloud.springdeeplearning.ioc.init_destroy.bean.Yingyingying;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Kim QQ.Cong on 2019-08-30 / 17:05
 *
 * @author: CongQingquan
 * @Description: init destroy 测试
 */
public class InitDestroyTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            InitDestroyConfiguration.class);
        context.getBean(Yingyingying.class);
        context.close();
    }
}