package com.Dumbass.RouletteofAkashicRecords.repository.choice;

import com.Dumbass.RouletteofAkashicRecords.domain.Platform;
import com.Dumbass.RouletteofAkashicRecords.domain.Subject;
import com.Dumbass.RouletteofAkashicRecords.repository.log.LogRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
@RequiredArgsConstructor
public class DBChoiceRepository implements ChoiceRepository{

    private final EntityManager em;
    private final LogRepository logRepository;

    @Override
    public Subject findSubject() {

        Subject subject = em.createQuery("select e from Subject e ORDER BY RAND() LIMIT 1", Subject.class).getSingleResult();

        return subject;
    }

    @Override
    public Platform findPlatform() {

        Platform platform = em.createQuery("select p from Platform p ORDER BY RAND() LIMIT 1", Platform.class).getSingleResult();

        return platform;
    }
}
