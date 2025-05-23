package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.domain.enums.MissionStatus;
import umc.study.repository.UserMissionRepository.UserMissionRepository;
import umc.study.validation.annotation.DuplicateMission;

@Component
@RequiredArgsConstructor
public class MissionDuplicateValidator implements ConstraintValidator<DuplicateMission, Long> {

    private final UserMissionRepository userMissionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        Long userId = 1L; // 하드코딩

        // 이미 해당 유저가 해당 미션을 도전 중인지 확인
        return !userMissionRepository.existsByUserIdAndMissionIdAndStatus(userId, missionId, MissionStatus.DOING);
    }
}
