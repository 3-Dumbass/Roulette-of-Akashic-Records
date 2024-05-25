package com.Dumbass.RouletteofAkashicRecords.controller.log.dto;

import com.Dumbass.RouletteofAkashicRecords.domain.Log;
import com.Dumbass.RouletteofAkashicRecords.domain.Subject;
import com.Dumbass.RouletteofAkashicRecords.domain.User;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LogDto {
    private User id;
    private LocalDateTime log_date;
    private Subject content;
    // String platform;

    public static LogDto toDto(Log log) {
        return LogDto.builder()
                .id(log.getUser_id())
                .log_date(log.getLog_date())
                .content(log.getContent())
                .build();
    }
}
