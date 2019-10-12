package cn.springscloud.springdeeplearning.ioc.import_annotation.config;

import cn.springscloud.springdeeplearning.ioc.import_annotation.bean.Gray;
import cn.springscloud.springdeeplearning.ioc.import_annotation.custom.CustomImportBeanDefinitionRegister;
import cn.springscloud.springdeeplearning.ioc.import_annotation.custom.CustomImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Kim QQ.Cong on 2019-08-30 / 17:02
 *
 * @author: CongQingquan
 * @Description: @Import 测试
 *
 * 1. value{} 中可以直接导入bean的class, 但是注入的bean的名称为全类名, 而非类名首字母小写
 * 2. value{} 中可以导入一个配置类(@Configuration标注的配置类)
 * 3. value{} 中可以是一个实现了ImportSelector接口的实现类(如1, 注册的bean的名称为全限定名)
 * 4.value{} 中可以是一个实现了ImportBeanDefinitionRegister接口的实现类, 该接口会直接将BeanDefinitionRegister交给你, 自由度更高
 */
@Import(value = {
    Gray.class,
    OtherImportConfiguration.class,
    CustomImportSelector.class,
    CustomImportBeanDefinitionRegister.class
})
@Configuration
public class ImportTestConfiguration {

}