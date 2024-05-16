package com.study.app.domain;

import com.study.app.domain.common.BaseEntity;
import com.study.app.domain.mapping.MemberAllowance;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Allowance extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    private Boolean optional;

    @OneToMany(mappedBy = "allowance", cascade = CascadeType.ALL)
    private List<MemberAllowance> memberAllowances = new ArrayList<>();
}
