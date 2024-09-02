package shop.mtcoding.springv3.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import shop.mtcoding.springv3.core.interceptor.LoginInterceptor;

@Configuration // IoC에 저장됨 // 설정파일을 Configuration 으로 메모리에 띄움
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 이제 컨트롤러 사이에 얘가 뜬거야
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/api/**");
//                .addPathPatterns("/user/**")
//                .addPathPatterns("/board/**");
    }
}
