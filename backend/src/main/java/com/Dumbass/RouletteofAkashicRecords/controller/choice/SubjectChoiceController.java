package com.Dumbass.RouletteofAkashicRecords.controller.choice;

import com.Dumbass.RouletteofAkashicRecords.controller.choice.dto.SubjectChoiceDto;
import com.Dumbass.RouletteofAkashicRecords.controller.log.LogController;
import com.Dumbass.RouletteofAkashicRecords.controller.subject.dto.SubjectRemoveRequest;
import com.Dumbass.RouletteofAkashicRecords.domain.Log;
import com.Dumbass.RouletteofAkashicRecords.domain.Subject;
import com.Dumbass.RouletteofAkashicRecords.repository.choice.ChoiceRepository;
import com.Dumbass.RouletteofAkashicRecords.service.ChoiceService;
import com.Dumbass.RouletteofAkashicRecords.service.LogService;
import com.Dumbass.RouletteofAkashicRecords.service.SubjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/random_choice")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "choice api", description = "뽑기 api")
public class SubjectChoiceController {

    private final ChoiceService choiceService;
    private final LogService logService;

    @GetMapping("/content")
    @Operation(summary = "주제 뽑기", description = "랜덤으로 뽑은 주제 출력")
    public ResponseEntity<String> choiceSubject() {
        log.info("주제 선택 실행");
        Subject subject = choiceService.choiceSubject();
        String subject_name = subject.getContent();
        logService.save(null, subject);
        return new ResponseEntity<>(subject_name, HttpStatus.CREATED);
    }

}


