package umc.study.repository.MissionRepository;

import umc.study.domain.Mission;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface MissionRepositoryCustom {
    List<Mission> dynamicQueryWithBooleanBuilder(String location, LocalDate dueDate);
}