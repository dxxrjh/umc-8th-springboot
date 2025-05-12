package umc.study.web.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDTO {

    private String content;
    private BigDecimal rate;
    private Long userId;
    private Long restaurantId;

    // getters and setters
}
