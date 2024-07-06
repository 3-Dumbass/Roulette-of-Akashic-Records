package com.Dumbass.RouletteofAkashicRecords.controller.log.dto;

import lombok.*;

@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LogRequest {
    private String subject_name;
    private Long writer;
    private String platform;

}
