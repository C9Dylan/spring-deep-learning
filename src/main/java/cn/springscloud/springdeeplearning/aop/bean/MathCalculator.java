package cn.springscloud.springdeeplearning.aop.bean;

import org.springframework.stereotype.Component;

/**
 * Created by Kim QQ.Cong on 2019-09-04 / 11:00
 *
 * @author: CongQingquan
 * @Description:
 */
@Component
public class MathCalculator {

    public Integer plus(Integer n1, Integer n2) {
        return n1 + n2;
    }

    public Integer minue(Integer n1, Integer n2) {
        return n1 - n2;
    }

    public Integer multiply(Integer n1, Integer n2) {
        return n1 * n2;
    }

    public Integer divide(Integer n1, Integer n2) {
        System.out.println("divide method execute");
        return n1 / n2;
    }
}