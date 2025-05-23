package umc.study.service.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.CategoryHandler;
import umc.study.converter.UserConverter;
import umc.study.converter.UserPreferConverter;
import umc.study.domain.Category;
import umc.study.domain.User;
import umc.study.domain.mapping.Preference;
import umc.study.repository.CategoryRepository;
import umc.study.repository.UserRepository.UserRepository;
import umc.study.web.dto.UserRequestDTO;

import java.util.List;
import java.util.prefs.Preferences;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService{

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;


    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDto request) {

        User newUser = UserConverter.toUser(request);

        List<Category> categoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return categoryRepository.findById(category).orElseThrow(() -> new CategoryHandler(ErrorStatus.CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<Preference> userPreferList = UserPreferConverter.toUserPreferList(categoryList);

        Preference preference = Preference.builder().build();
        userPreferList.forEach(userPrefer -> {
            userPrefer.setUser(newUser);});

        return userRepository.save(newUser);
    }
}
