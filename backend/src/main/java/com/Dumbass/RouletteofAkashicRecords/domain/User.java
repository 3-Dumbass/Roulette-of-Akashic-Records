package com.Dumbass.RouletteofAkashicRecords.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String name;

    public User(String name) {
        if(name.isBlank()){
            throw new IllegalArgumentException("이름이 비어있거나 공백으로만 이루어져 있습니다");
        }
        this.name = name;
    }
}
