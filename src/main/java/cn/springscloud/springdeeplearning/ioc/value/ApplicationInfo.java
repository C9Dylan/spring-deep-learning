package cn.springscloud.springdeeplearning.ioc.value;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Kim QQ.Cong on 2019-09-02 / 17:46
 *
 * @author: CongQingquan
 * @Description:
 */
public class ApplicationInfo {
    /**
     * 三种取值方式:
     *
     * 1. 显示赋值
     *
     * 2. SpEl: #{}
     *
     * 3. 读取配置文件(环境变量)中的值: ${}
     *
     * PostScript: 被加载的配置会被装载到Environment中
     */

    /**
     * 1. 显示赋值
     */
    @Value("Study")
    private String projectType;

    /**
     * 2. SpEl
     */
    @Value("#{20 * 10}")
    private Integer sum;

    /**
     * 3. ${}
     */
    @Value("${server.port}")
    private Integer port;

    @Value("${project.name}")
    private String projectName;

    @Override
    public String toString() {
        return "ApplicationInfo{" +
            "projectType='" + projectType + '\'' +
            ", sum=" + sum +
            ", port=" + port +
            ", projectName='" + projectName + '\'' +
            '}';
    }
}