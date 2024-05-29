package com.Dumbass.RouletteofAkashicRecords.controller.platform;


import com.Dumbass.RouletteofAkashicRecords.controller.platform.dto.PlatformRemoveRequest;
import com.Dumbass.RouletteofAkashicRecords.controller.platform.dto.PlatformSaveRequest;
import com.Dumbass.RouletteofAkashicRecords.controller.subject.dto.SubjectRemoveRequest;
import com.Dumbass.RouletteofAkashicRecords.service.PlatformService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/platform")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "platform api", description = "플랫폼와 관련된 api")
public class PlatformController {
    private final PlatformService platformService;

    @PostMapping("/save")
    @Operation(summary = "플랫폼 저장", description = "사용자가 입력란 플랫폼을 저장")
    public ResponseEntity<Long> savePlatform(@RequestBody @Valid PlatformSaveRequest platformSaveRequest){
        log.info("플랫폼 입력:" + platformSaveRequest.getContent());
        Long id = platformService.savePlatform(platformSaveRequest.getContent(), null);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @PostMapping("/remove")
    @Operation(summary = "플랫폼 삭제", description = "사용자가 요구한 플랫폼 삭제")
    public ResponseEntity<Void> removeSubject(@RequestBody @Valid PlatformRemoveRequest platformRemoveRequest){
        log.info("플랫폼 삭제: " + platformRemoveRequest.getPlatformId());
        platformService.deleteSubject(platformRemoveRequest.getPlatformId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
