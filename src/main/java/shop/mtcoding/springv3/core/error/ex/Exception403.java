package shop.mtcoding.springv3.core.error.ex;

// 인증 관련 (인증이 안되어있을 때, 얘를 터트릴거야)
public class Exception403 extends RuntimeException {
    public Exception403(String message) {
        super(message);
    }
}
