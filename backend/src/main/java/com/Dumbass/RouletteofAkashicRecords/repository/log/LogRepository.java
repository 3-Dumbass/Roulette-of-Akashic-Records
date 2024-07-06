package com.Dumbass.RouletteofAkashicRecords.repository.log;

import com.Dumbass.RouletteofAkashicRecords.domain.Log;
import com.Dumbass.RouletteofAkashicRecords.domain.Platform;
import com.Dumbass.RouletteofAkashicRecords.domain.Subject;
import com.Dumbass.RouletteofAkashicRecords.domain.User;

public interface LogRepository {

    Subject findSubject(String subjectContent);
    User findUser(Long writer);
    Platform findPlatform(String platformContent);

    Boolean saveLog(Log log);
}
