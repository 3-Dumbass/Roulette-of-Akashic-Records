package com.Dumbass.RouletteofAkashicRecords.controller.subject;

import com.Dumbass.RouletteofAkashicRecords.controller.subject.dto.SubjectSaveDto;
import com.Dumbass.RouletteofAkashicRecords.service.SubjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subject")
@RequiredArgsConstructor
@Slf4j
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping("/save")
    public ResponseEntity<Long> saveSubject(@RequestBody @Valid SubjectSaveDto subjectSaveDto){
        log.info("주제 입력: "+subjectSaveDto.getContent());
        Long id = subjectService.saveSubject(subjectSaveDto.getContent());
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }
}
