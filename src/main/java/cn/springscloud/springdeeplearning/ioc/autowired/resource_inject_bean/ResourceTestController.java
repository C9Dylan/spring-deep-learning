package cn.springscloud.springdeeplearning.ioc.autowired.resource_inject_bean;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;

/**
 * Created by Kim QQ.Cong on 2019-09-02 / 20:20
 *
 * @author: CongQingquan
 * @Description:
 */
@Controller
public class ResourceTestController {
    @Inject
    public ResourceInjectTestService resourceInjectTestService;
}