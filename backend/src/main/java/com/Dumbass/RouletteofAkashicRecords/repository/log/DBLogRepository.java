package com.Dumbass.RouletteofAkashicRecords.repository.log;

import com.Dumbass.RouletteofAkashicRecords.domain.Log;
import com.Dumbass.RouletteofAkashicRecords.domain.Platform;
import com.Dumbass.RouletteofAkashicRecords.domain.Subject;
import com.Dumbass.RouletteofAkashicRecords.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class DBLogRepository implements LogRepository {

    private final EntityManager em;

    @Override
    public Subject findSubject(String subjectContent) {
        TypedQuery<Subject> query = em.createQuery("Select s from Subject s where s.content = :content", Subject.class);
        query.setParameter("content", subjectContent);
        Subject subject = query.getSingleResult();

        return subject;
    }

    @Override
    public User findUser(Long writer) {
        TypedQuery<User> query = em.createQuery("Select u from User u where u.id = :username", User.class);
        query.setParameter("username", writer);
        User user = query.getSingleResult();

        return user;
    }

    @Override
    public Platform findPlatform(String platformContent) {
        TypedQuery<Platform> query = em.createQuery("Select p from Platform p where p.content = :content", Platform.class);
        query.setParameter("content", platformContent);
        Platform platform = query.getSingleResult();

        return platform;
    }

    @Override
    public Boolean saveLog(Log log) {
        try{
            em.persist(log);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

}
