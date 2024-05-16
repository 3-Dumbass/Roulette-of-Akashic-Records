package com.Dumbass.RouletteofAkashicRecords.repository;

import com.Dumbass.RouletteofAkashicRecords.domain.Subject;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DbSubjectRepository implements SubjectRepository{

    private final EntityManager em;


    @Override
    public Long save(Subject subject) {
        em.persist(subject);
        return subject.getId();
    }

    @Override
    public Subject findById(Long id) {
        return em.find(Subject.class, id);
    }

    @Override
    public void deleteById(Long id) {
        //TODO: 차후 개발
    }
}
