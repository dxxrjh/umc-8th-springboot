package umc.study.repository.UserRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QUser;
import umc.study.domain.User;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QUser user = QUser.user;

    @Override
    public List<User> dynamicQueryWithBooleanBuilder(long id) {
        BooleanBuilder predicate = new BooleanBuilder();

        // id 조건 추가
        predicate.and(user.id.eq(id));  // user.user.id로 접근

        // 쿼리 실행
        return jpaQueryFactory
                .selectFrom(user)
                .where(predicate)
                .fetch();
    }
}
