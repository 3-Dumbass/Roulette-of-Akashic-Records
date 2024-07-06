package com.Dumbass.RouletteofAkashicRecords.controller.choice;

import com.Dumbass.RouletteofAkashicRecords.controller.choice.dto.ChoiceDto;
import com.Dumbass.RouletteofAkashicRecords.domain.Platform;
import com.Dumbass.RouletteofAkashicRecords.domain.Subject;
import com.Dumbass.RouletteofAkashicRecords.domain.User;
import com.Dumbass.RouletteofAkashicRecords.service.ChoiceService;
import com.Dumbass.RouletteofAkashicRecords.service.LogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/random")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "choice api", description = "뽑기 api")
public class ChoiceController {

    private final ChoiceService choiceService;


    /** return ResponseEntity<Pair<String, String>>*/
    @PostMapping("/choice")
    @Operation(summary = "주제 뽑기", description = "랜덤으로 뽑은 주제 출력")
    public ResponseEntity<ChoiceDto> choice() {
        log.info("주제 선택 실행");

        Subject subject = choiceService.choiceSubject();
        String subject_name = subject.getContent();

        User user = subject.getWriter();
        String subject_writer = user.getName();

        Platform platform = choiceService.choicePlatform();
        String platform_name = platform.getContent();

        ChoiceDto choiceDto = new ChoiceDto(subject_name, subject_writer, platform_name);
        return new ResponseEntity<>(choiceDto, HttpStatus.CREATED);
    }

}


