package cn.springscloud.springdeeplearning.ioc.autowired.resource_inject_bean;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;

/**
 * Created by Kim QQ.Cong on 2019-09-02 / 20:20
 *
 * @author: CongQingquan
 * @Description:
 */
@Controller
public class InjectTestController {
    @Resource(name = "resourceInjectTestService")
    public ResourceInjectTestService resourceInjectTestService;
}