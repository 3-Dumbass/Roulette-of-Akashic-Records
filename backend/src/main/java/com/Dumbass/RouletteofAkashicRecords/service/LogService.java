package com.Dumbass.RouletteofAkashicRecords.service;

import com.Dumbass.RouletteofAkashicRecords.controller.log.dto.LogRequest;
import com.Dumbass.RouletteofAkashicRecords.domain.Log;
import com.Dumbass.RouletteofAkashicRecords.domain.Platform;
import com.Dumbass.RouletteofAkashicRecords.domain.Subject;
import com.Dumbass.RouletteofAkashicRecords.domain.User;
import com.Dumbass.RouletteofAkashicRecords.repository.log.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;

    public Boolean save(LogRequest logRequest) {

        User writer = logRepository.findUser(logRequest.getWriter());
        Subject subjectName = logRepository.findSubject(logRequest.getSubject_name());
        Platform platform = logRepository.findPlatform(logRequest.getPlatform());

        LocalDateTime currentDateTime = LocalDateTime.now();

        Log log = new Log(writer, currentDateTime, subjectName, platform);

        return logRepository.saveLog(log);
    }

}
