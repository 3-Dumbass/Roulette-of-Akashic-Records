package com.Dumbass.RouletteofAkashicRecords.controller.subject;

import com.Dumbass.RouletteofAkashicRecords.controller.subject.dto.SubjectRemoveRequest;
import com.Dumbass.RouletteofAkashicRecords.controller.subject.dto.SubjectSaveDto;
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
@RequestMapping("/api/subject")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "subject api", description = "주제와 관련된 api")
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping("/save")
    @Operation(summary = "주제 저장", description = "사용자가 입력란 주제를 저장")
    public ResponseEntity<Long> saveSubject(@RequestBody @Valid SubjectSaveDto subjectSaveDto){
        log.info("주제 입력: "+subjectSaveDto.getContent());
        Long id = subjectService.saveSubject(subjectSaveDto.getContent());
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @DeleteMapping("/remove")
    @Operation(summary = "주제 삭제", description = "사용자가 요구한 주제를 삭제")
    public ResponseEntity<Void> removeSubject(@RequestBody @Valid SubjectRemoveRequest subjectRemoveRequest){
        log.info("주제 삭제: "+subjectRemoveRequest.getSubjectId());
        subjectService.deleteSubject(subjectRemoveRequest.getSubjectId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
