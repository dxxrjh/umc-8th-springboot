package umc.study.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPreference is a Querydsl query type for Preference
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPreference extends EntityPathBase<Preference> {

    private static final long serialVersionUID = -1221638531L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPreference preference = new QPreference("preference");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    public final umc.study.domain.QCategory category;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final umc.study.domain.QUser user;

    public QPreference(String variable) {
        this(Preference.class, forVariable(variable), INITS);
    }

    public QPreference(Path<? extends Preference> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPreference(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPreference(PathMetadata metadata, PathInits inits) {
        this(Preference.class, metadata, inits);
    }

    public QPreference(Class<? extends Preference> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new umc.study.domain.QCategory(forProperty("category")) : null;
        this.user = inits.isInitialized("user") ? new umc.study.domain.QUser(forProperty("user")) : null;
    }

}

