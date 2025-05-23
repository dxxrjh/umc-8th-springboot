package umc.study.service.UserService;

import jakarta.validation.Valid;
import umc.study.domain.User;
import umc.study.web.dto.UserRequestDTO;

public interface UserCommandService {

    User joinUser(UserRequestDTO.@Valid JoinDto request);
}
