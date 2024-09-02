package shop.mtcoding.springv3.core.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import shop.mtcoding.springv3.core.error.ex.Exception401;
import shop.mtcoding.springv3.user.User;

public class LoginInterceptor implements HandlerInterceptor { // 다형성으로 LoginInterceptor 는 HandlerInterceptor 타입임
    // default 는 니가 쓰고싶은거만 쓸 수 있음, 추상메서드면 3개 다 구현해야한다.
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) { // 디스패처서블릿이 request, response 전달해주는 것
//        System.out.println("프리핸들 동작함 ---------------------------------------");
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("sessionUser");

        if (sessionUser == null) {
            throw new Exception401("인증되지 않았어요.");
        }

        return true; // false 면 컨트롤러 진입안됨
    }

}
