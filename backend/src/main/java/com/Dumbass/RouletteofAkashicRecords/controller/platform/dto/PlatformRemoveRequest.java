package com.Dumbass.RouletteofAkashicRecords.controller.platform.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlatformRemoveRequest {
    @NotNull
    private Long platformId;
}
