package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    @Operation(summary = "기본 페이지",description = "접속 확인용 메인 페이지")
    public String home() {
        return "Hello, Spring Boot!";
    }
}
