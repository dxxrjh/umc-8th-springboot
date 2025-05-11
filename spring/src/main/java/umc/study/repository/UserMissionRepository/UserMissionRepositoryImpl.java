package umc.study.repository.UserMissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.QuserMission;
import umc.study.domain.mapping.userMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserMissionRepositoryImpl implements UserMissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QuserMission userMission = QuserMission.userMission;

    @Override
    public List<userMission> dynamicQueryWithBooleanBuilder(long id, String status) {
        BooleanBuilder predicate = new BooleanBuilder();

        // id 조건 추가
        predicate.and(userMission.user.id.eq(id));  // user.user.id로 접근

        // status 조건 추가
        if (status != null) {
            predicate.and(userMission.status.eq(MissionStatus.valueOf(status)));
        }

        // 쿼리 실행
        return jpaQueryFactory
                .selectFrom(userMission)
                .join(userMission.user).fetchJoin()
                .where(predicate)
                .fetch();
    }
}
