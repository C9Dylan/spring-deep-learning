package cn.springscloud.springdeeplearning.ioc.scan.custom;

import java.io.IOException;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
 * Created by Kim QQ.Cong on 2019-08-30 / 15:55
 *
 * @author: CongQingquan
 * @Description: 自定义扫描过滤器
 *
 * 1. 实现TypeFilter接口 2. match 函数内编写过滤逻辑(true为匹配, 则不会扫描)
 */
public class CustomScanFilter implements TypeFilter {

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
        throws IOException {
        // Do nothing
        return false;
    }
}