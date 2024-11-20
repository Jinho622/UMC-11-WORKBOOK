package umc.workbook7.web.dto.Member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.workbook7.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {
    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min = 5, max = 20)
        String address;
        @Size(min = 5, max = 20)
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }
}
