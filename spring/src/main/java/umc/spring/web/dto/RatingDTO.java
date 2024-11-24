package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistStore;

public class RatingDTO {

    @Getter
    public static class CreateRating {

        @NotNull
        Integer rate;

        String ratingContent;

        @NotNull
        Long missionId;

        @NotNull
        @ExistMember
        Long memberId;

        @NotNull
        @ExistStore
        Long storeId;
    }
}
