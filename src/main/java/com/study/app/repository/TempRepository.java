package com.study.app.repository;

import com.study.app.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempRepository extends JpaRepository<Member, Long> {

}
