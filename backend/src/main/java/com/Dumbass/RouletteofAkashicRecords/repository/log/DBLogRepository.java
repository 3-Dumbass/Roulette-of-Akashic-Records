package com.Dumbass.RouletteofAkashicRecords.repository.log;

import com.Dumbass.RouletteofAkashicRecords.controller.log.dto.LogDto;
import com.Dumbass.RouletteofAkashicRecords.domain.Log;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class DBLogRepository implements LogRepository {

    private final EntityManager em;

    @Override
    public void saveLog(Log log) {
        em.persist(log);
    }

}
