package com.Dumbass.RouletteofAkashicRecords.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * user_id, log_date, content, platform_id */
public class Log {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = true)
    private User user_id;

    @Id
    private LocalDateTime log_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content",nullable = true)
    private Subject content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "platform_id",nullable = true)
    private Platform platform_id;
}
