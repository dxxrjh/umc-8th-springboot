package umc.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.Mission;
import umc.study.domain.User;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'DOING'")
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    // user에 대한 getter 추가
    public User getUser() {
        return user;
    }

    // mission에 대한 getter 추가
    public Mission getMission() {
        return mission;
    }

    @Override
    public String toString() {
        return "UserMission{" +
                "id=" + id +
                ", status=" + status +
                ", userId=" + (user != null ? user.getId() : null) +
                ", mission=" + (mission != null ? mission.getDueDate() + ", " + mission.getDescription()+ ", " + mission.getPoint()+ ", " + mission.getRestaurant() : null) +
                '}';
    }


}
