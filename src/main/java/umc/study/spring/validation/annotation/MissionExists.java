package umc.study.spring.validation.annotation;



import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.spring.validation.validator.MissionExistsValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionExistsValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })//어노테이션의 적용 범위를 지정
@Retention(RetentionPolicy.RUNTIME)
public @interface MissionExists {

    String message() default "해당하는 가게가 없습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}