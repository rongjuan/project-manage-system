package cc.xuepeng.config;

import cc.xuepeng.interceptor.SecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Web配置类。
 *
 * @author xuepeng
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    /**
     * 添加拦截器。
     *
     * @param registry 拦截器注册器。
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(defaultInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/pms/*/users/*/user/login")
                .excludePathPatterns("/pms/*/users/*/user/info");
        super.addInterceptors(registry);
    }

    /**
     * 设置拦截器。
     *
     * @param defaultInterceptor 拦截器。
     */
    @Autowired
    public void setDefaultInterceptor(SecurityInterceptor defaultInterceptor) {
        this.defaultInterceptor = defaultInterceptor;
    }

    /**
     * 拦截器。
     */
    private SecurityInterceptor defaultInterceptor;

}
