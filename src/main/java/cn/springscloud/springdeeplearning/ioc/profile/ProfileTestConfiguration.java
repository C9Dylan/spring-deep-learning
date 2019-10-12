package cn.springscloud.springdeeplearning.ioc.profile;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

/**
 * Created by Kim QQ.Cong on 2019-09-03 / 17:03
 *
 * @author: CongQingquan
 * @Description:
 */
@PropertySource("classpath:/database_configuration.properties")
@Configuration
public class ProfileTestConfiguration implements EmbeddedValueResolverAware {

    private StringValueResolver stringValueResolver;

    @Value("${db.username}")
    private String userName;

    @Value("${db.password}")
    private String password;

    @Value("${db.driverClass}")
    private String driverClass;

    @Profile({
        "dev"
    })
    @Bean("devEnvironmentDataSource")
    public DataSource devEnvironmentDataSource(@Value("${db.driverClass}") String driverClass) {
        DruidDataSource devEnvironmentDataSource = new DruidDataSource();
        devEnvironmentDataSource.setUsername(userName);
        devEnvironmentDataSource.setPassword(password);
        devEnvironmentDataSource.setDriverClassName(driverClass);
        devEnvironmentDataSource.setUrl(stringValueResolver.resolveStringValue("${db.jdbcUrl}"));
        return devEnvironmentDataSource;
    }

    @Profile({
        "test"
    })
    @Bean("testEnvironmentDataSource")
    public DataSource testEnvironmentDataSource(@Value("${db.driverClass}") String driverClass) {
        DruidDataSource testEnvironmentDataSource = new DruidDataSource();
        testEnvironmentDataSource.setUsername(userName);
        testEnvironmentDataSource.setPassword(password);
        testEnvironmentDataSource.setDriverClassName(driverClass);
        testEnvironmentDataSource.setUrl(stringValueResolver.resolveStringValue("${db.jdbcUrl}"));
        return testEnvironmentDataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.stringValueResolver = stringValueResolver;
    }
}