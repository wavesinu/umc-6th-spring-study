package com.study.app.domain;

import com.study.app.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double star;

    @Column(length = 1000)
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<Image> images = new ArrayList<>();

    public void setMember(Member member) {
        this.member = member;
        member.getReviews().add(this);
    }

    public void setStore(Store store) {
        this.store = store;
        store.getReviews().add(this);
    }
}
