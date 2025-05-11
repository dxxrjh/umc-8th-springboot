package umc.study.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QMission;
import umc.study.domain.Mission;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;

    @Override
    public List<Mission> dynamicQueryWithBooleanBuilder(String location, LocalDate dueDate) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (location != null && !location.isEmpty()) {
            predicate.and(mission.restaurant.location.name.containsIgnoreCase(location));
        }
        predicate.and(mission.dueDate.goe(dueDate));

        // 쿼리 실행
        return jpaQueryFactory
                .selectFrom(mission)
                .join(mission.restaurant).fetchJoin()
                .where(predicate)
                .fetch();
    }
}
