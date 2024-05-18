package com.Dumbass.RouletteofAkashicRecords.controller.subject.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectRemoveRequest {
    @NotNull
    private Long subjectId;
}
