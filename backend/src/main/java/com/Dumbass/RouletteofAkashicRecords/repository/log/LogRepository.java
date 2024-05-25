package com.Dumbass.RouletteofAkashicRecords.repository.log;

import com.Dumbass.RouletteofAkashicRecords.controller.log.dto.LogDto;
import com.Dumbass.RouletteofAkashicRecords.domain.Log;

public interface LogRepository {

    void saveLog(Log log);
}
