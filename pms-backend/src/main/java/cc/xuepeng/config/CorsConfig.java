package cc.xuepeng.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域配置。
 *
 * @author xuepeng
 */
@Configuration
public class CorsConfig {

    /**
     * 设置跨域过滤器。
     *
     * @return 跨域过滤器。
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }

    /**
     * 构建跨域配置。
     *
     * @return 跨域配置。
     */
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

}
