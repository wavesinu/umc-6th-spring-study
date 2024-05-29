package com.study.app.repository;

import com.study.app.domain.mapping.ChallengeMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeMissionRepository extends JpaRepository<ChallengeMission, Long> {
    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);
}
