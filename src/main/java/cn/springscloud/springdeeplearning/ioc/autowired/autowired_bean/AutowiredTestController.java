package cn.springscloud.springdeeplearning.ioc.autowired.autowired_bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Created by Kim QQ.Cong on 2019-09-02 / 20:10
 *
 * @author: CongQingquan
 * @Description:
 */
@Controller
public class AutowiredTestController {

    @Qualifier("autowiredTestServiceImpl2")
    @Autowired()
//    @Autowired(required = false)
    private AutowiredTestService autowiredTestService;

    public void print() {
        System.out.println(autowiredTestService);
    }
}