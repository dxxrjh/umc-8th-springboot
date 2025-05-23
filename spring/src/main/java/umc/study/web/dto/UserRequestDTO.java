package umc.study.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.validation.annotation.ExistCategories;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class UserRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotNull
        String birthday;
        String address;
        @Email
        String email;
        String phoneNumber;
        @ExistCategories
        List<Long> preferCategory;
    }
}

