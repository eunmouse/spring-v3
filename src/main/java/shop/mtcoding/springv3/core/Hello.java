package shop.mtcoding.springv3.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME) // 실행시키다가 발동 할 수 있게, 컴파일 타임이 아니라
public @interface Hello {
}
