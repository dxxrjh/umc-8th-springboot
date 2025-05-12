package umc.study;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.study.web.dto.ReviewDTO;
import umc.study.service.ReviewService.ReviewQueryService;

import java.math.BigDecimal;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {

			ReviewQueryService reviewService = context.getBean(ReviewQueryService.class);

			// 파라미터 값 설정
			Long userId = 1L;
			Long restaurantId = 1L;
			String content = "음식이 정말 맛있었고 서비스도 친절했어요!";
			BigDecimal rate = BigDecimal.valueOf(4.5);

			System.out.println("Executing createReview with parameters:");
			System.out.println("UserId: " + userId);
			System.out.println("RestaurantId: " + restaurantId);
			System.out.println("Content: " + content);
			System.out.println("Rate: " + rate);

			// DTO 생성
			ReviewDTO dto = new ReviewDTO();
			dto.setUserId(userId);
			dto.setRestaurantId(restaurantId);
			dto.setContent(content);
			dto.setRate(rate);

			// 서비스 호출
			var result = reviewService.createReview(dto);
			System.out.println("✅ 리뷰 작성 완료:");
			System.out.println(result);
		};
	}
}