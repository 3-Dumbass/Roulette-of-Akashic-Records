package com.Dumbass.RouletteofAkashicRecords.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Subject {
    @Id
    @GeneratedValue
    @Column(name = "subject_id")
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = true)//TODO: 추후 로그인 기능 완성시 수정
    private User writer;

    @CreatedDate
    private LocalDateTime createDate;

    public Subject(String content, User writer) {
        if(content.isBlank()){
            throw new IllegalArgumentException("문자열이 비어있거나 공백으로만 이루어져 있습니다");
        }
        this.content = content;
        this.writer = writer;
    }
}
