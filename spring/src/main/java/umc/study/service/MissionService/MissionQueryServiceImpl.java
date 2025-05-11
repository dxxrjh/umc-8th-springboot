package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Mission;
import umc.study.repository.MissionRepository.MissionRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService{

    private final MissionRepository MissionRepository;

    @Override
    public Optional<Mission> findMission(Long id) {
        return MissionRepository.findById(id);
    }

    @Override
    public List<Mission> findMissionsByLocationAndDueDate(String location , LocalDate dueDate) {
        List<Mission> filteredMission = MissionRepository.dynamicQueryWithBooleanBuilder(location, dueDate);

        filteredMission.forEach(Mission -> System.out.println("Mission: " + Mission));

        return filteredMission;
    }
}