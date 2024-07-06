package com.Dumbass.RouletteofAkashicRecords.controller.log.dto;

import lombok.*;

@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LogRequest {
    private String subject_name;
    private String writer;
    private String platform;

}
