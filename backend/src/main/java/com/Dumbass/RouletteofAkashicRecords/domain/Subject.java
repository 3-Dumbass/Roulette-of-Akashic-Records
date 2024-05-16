package com.Dumbass.RouletteofAkashicRecords.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    private Long id;

    private String content;

    @CreatedDate
    private LocalDateTime createDate;

    public Subject(String subject) {
        if(subject.isBlank()){
            throw new IllegalArgumentException("문자열이 비어있거나 공백으로만 이루어져 있습니다");
        }
        this.content = subject;
    }
}
