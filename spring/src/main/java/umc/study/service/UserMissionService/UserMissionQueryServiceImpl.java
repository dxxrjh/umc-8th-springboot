package umc.study.service.UserMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.PageHandler;
import umc.study.domain.User;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;
import umc.study.repository.UserMissionRepository.UserMissionRepository;
import umc.study.repository.UserRepository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserMissionQueryServiceImpl implements UserMissionQueryService{

    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    public Page<UserMission> getUserMissionList(long userId, String status, Integer page) {
        System.out.println(">>> 들어온 page: " + page); // ✅ 로그
        // 페이지 유효성 검사
        if (page == null || page < 1) {
            System.out.println(">>> PAGE ERROR 발생"); // ✅ 로그
            throw new PageHandler(ErrorStatus.PAGE_NOT_VALID);
        }

        // 검증된 페이지 값만 PageRequest 생성
        int zeroBasedPage = page - 1; // 0 기반으로 변환
        PageRequest pageRequest = PageRequest.of(zeroBasedPage, 10);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        MissionStatus missionStatus = MissionStatus.valueOf(status.toUpperCase());

        return userMissionRepository.findAllByUserAndStatus(user, missionStatus, pageRequest);
    }
}