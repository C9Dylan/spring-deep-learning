package cn.springscloud.springdeeplearning.ioc.import_annotation.custom;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by Kim QQ.Cong on 2019-08-30 / 17:16
 *
 * @author: CongQingquan
 * @Description: 自定义导入逻辑
 *
 * 1. 实现ImportSelector
 * 2. 根据selectImports返回的String中的类的全限定名称创建bean(注册的bean的名称为全限定名)
 */
public class CustomImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
            "cn.springscloud.springdeeplearning.ioc.import_annotation.bean.Red"
        };
    }
}