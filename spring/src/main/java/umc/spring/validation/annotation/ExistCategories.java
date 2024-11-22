package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.CategoriesExistValidator;

import java.lang.annotation.*;

@Documented     //사용자 정의 어노테이션
@Constraint(validatedBy = CategoriesExistValidator.class)   //지정된 클래스를 통해 ExistCategories가 붙은 대상을 검증한다.
@Target( {ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER} )    //어노테이션의 적용 범위.
@Retention(RetentionPolicy.RUNTIME)     //어노테이션의 생명 주기. runtime인 경우에만 작용된다.
public @interface ExistCategories {

    String message() default "해당하는 카테고리가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
