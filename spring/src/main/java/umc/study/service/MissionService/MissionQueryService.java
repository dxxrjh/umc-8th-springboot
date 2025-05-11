package umc.study.service.MissionService;

import umc.study.domain.Mission;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MissionQueryService {

    Optional<Mission> findMission(Long id);
    List<Mission> findMissionsByLocationAndDueDate(String location, LocalDate dueDate);
}