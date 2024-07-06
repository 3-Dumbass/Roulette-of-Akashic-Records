package com.Dumbass.RouletteofAkashicRecords.controller.log;

import com.Dumbass.RouletteofAkashicRecords.controller.log.dto.LogRequest;
import com.Dumbass.RouletteofAkashicRecords.service.LogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/log")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "log api", description = "뽑은 주제 기록 api")
public class LogController {

    private final LogService logService;

    @PostMapping("/save")
    @Operation(summary = "주제 기록", description = "랜덤으로 뽑은 주제 기록")
    public ResponseEntity<Boolean> LogSaveSubject(@RequestBody @Valid LogRequest logRequest) {
        log.info("주제 기록 실행");

        Boolean log_check = logService.save(logRequest);
        return new ResponseEntity<>(log_check, HttpStatus.CREATED);
    }

}
