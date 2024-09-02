package shop.mtcoding.springv3.core.error;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import shop.mtcoding.springv3.core.error.ex.Exception400;

@Component // IoC 에도 올려야 하잖아, 컴포넌트 스캔이 되면 new 함
@Aspect // AOP 등록 // 관점이라는 뜻
public class GlobalValidationHandler {

    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping) || @annotation(org.springframework.web.bind.annotation.PutMapping)")
    public void validCheck(JoinPoint jp) {
        Object[] args = jp.getArgs(); // 메서드의 매개변수를 다 들고와
        for (Object arg : args) {
            if (arg instanceof Errors) { // instanceof 타입검사, Errors 가 있다면
                Errors errors = (Errors) arg;

                if (errors.hasErrors()) { // 에러가 있으면 true 가 뜸
                    for (FieldError error : errors.getFieldErrors()) { // 에러가 존재할때 for 문 돌려
                        throw new Exception400(error.getDefaultMessage() + " : " + error.getField()); // getField 는 title
                    } // 에러를 한꺼번에 다 알릴 필요가 없다. 한개씩 날려
                }
            }
        }

//        for (Object arg : args) {
//            System.out.println("사이즈 : " + args.length);
//        }
//        for (Object arg : args) {
//            System.out.println(arg);
//        }
    }
}
