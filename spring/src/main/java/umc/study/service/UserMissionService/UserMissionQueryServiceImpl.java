package umc.study.service.UserMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.mapping.UserMission;
import umc.study.repository.UserMissionRepository.UserMissionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserMissionQueryServiceImpl implements UserMissionQueryService{

    private final UserMissionRepository userMissionRepository;

    @Override
    public Optional<UserMission> findUserMission(Long id) {
        return userMissionRepository.findById(id);
    }

    @Override
    public List<UserMission> findUserMissionsByIdAndStatus(long id, String status) {
        List<UserMission> filteredUserMission = userMissionRepository.dynamicQueryWithBooleanBuilder(id, status);

        filteredUserMission.forEach(userMission -> System.out.println("UserMission: " + userMission));

        return filteredUserMission;
    }
}