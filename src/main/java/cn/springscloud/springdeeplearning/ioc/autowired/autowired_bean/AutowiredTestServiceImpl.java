package cn.springscloud.springdeeplearning.ioc.autowired.autowired_bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Created by Kim QQ.Cong on 2019-09-02 / 19:34
 *
 * @author: CongQingquan
 * @Description:
 */
@Primary
@Service
public class AutowiredTestServiceImpl implements AutowiredTestService {

    private Integer level = 1;

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "AutowiredTestServiceImpl{" +
            "level=" + level +
            '}';
    }
}