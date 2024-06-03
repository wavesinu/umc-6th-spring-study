package com.study.app.domain.mapping;

import com.study.app.domain.Member;
import com.study.app.domain.Mission;
import com.study.app.domain.enums.MissionStatus;
import com.study.app.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ChallengeMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
//    @Column(columnDefinition = "VARCHAR(30) DEFAULT 'CHALLENGING'")
    @Column(columnDefinition = "VARCHAR(30)")
    private MissionStatus missionStatus = MissionStatus.CHALLENGING;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;
}