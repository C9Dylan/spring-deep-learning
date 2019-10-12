package cn.springscloud.springdeeplearning.web.servlet3.containerinitializer;

import cn.springscloud.springdeeplearning.web.servlet3.handle.InitializationHandle;
import cn.springscloud.springdeeplearning.web.servlet3.servlet.HelloServlet;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;

/**
 * Created by Kim QQ.Cong on 2019-09-05 / 14:34
 *
 * @author: CongQingquan
 * @Description: Web容器初始化器
 */
@HandlesTypes({
    InitializationHandle.class
})
public class MyServletContainerInitializer implements ServletContainerInitializer {

    /**
     * Web应用启动时会调该初始化器
     *
     * PS: 需要在Jar的META-INF下的javax.servlet.ServletContainerInitializer进行配置
     *      将全类名放在该配置文件内, 以供扫描后执行onStartup函数
     *
     * @param args @HandlesTypes注解中指定的类或接口的所有子类或子接口
     * @param servletContext Web应用的上下文
     * @throws ServletException
     */
    @Override
    public void onStartup(Set<Class<?>> args, ServletContext servletContext) throws ServletException {
        // 1. @HandlesType 中指定的组件
        for (Iterator<Class<?>> iterator = args.iterator(); iterator.hasNext(); ) {
            Class<?> next =  iterator.next();
            System.out.println(next.getName());
        }

        // 2. 手动注册三大组件
        ServletRegistration.Dynamic servletDynamic = servletContext.addServlet("helloServlet", new HelloServlet());
        servletDynamic.addMapping("/hello");
        servletDynamic.addMapping("/hi");
        // 拦截器, 监听器一样的配置... 不过返回的Dynamic类型不同
    }
}