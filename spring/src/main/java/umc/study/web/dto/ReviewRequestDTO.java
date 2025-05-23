package umc.study.web.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


public class ReviewRequestDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Getter
    public static class ReviewWritingDTO{
        private String content;
        @NotNull
        private BigDecimal rate;
    }
}
