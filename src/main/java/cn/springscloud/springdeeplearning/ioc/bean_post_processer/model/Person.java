package cn.springscloud.springdeeplearning.ioc.bean_post_processer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Kim QQ.Cong on 2019-09-02 / 14:46
 *
 * @author: CongQingquan
 * @Description:
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;

    private Integer age;
}