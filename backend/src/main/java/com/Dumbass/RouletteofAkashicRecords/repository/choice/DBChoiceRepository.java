package com.Dumbass.RouletteofAkashicRecords.repository.choice;

import com.Dumbass.RouletteofAkashicRecords.controller.log.dto.LogDto;
import com.Dumbass.RouletteofAkashicRecords.domain.Log;
import com.Dumbass.RouletteofAkashicRecords.domain.Subject;
import com.Dumbass.RouletteofAkashicRecords.repository.log.LogRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
@RequiredArgsConstructor
public class DBChoiceRepository implements ChoiceRepository{

    private final EntityManager em;
    private final LogRepository logRepository;

    @Override
    public Subject findSubject() {

        Subject subject = em.createQuery("select e from Subject e ORDER BY RANDOM() LIMIT 1", Subject.class).getSingleResult();


        return null;
    }
}
