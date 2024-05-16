package com.Dumbass.RouletteofAkashicRecords.controller.subject.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectSaveDto {
    @NotBlank
    private String content;


}
