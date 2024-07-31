package com.Dumbass.RouletteofAkashicRecords.repository.user;

import com.Dumbass.RouletteofAkashicRecords.domain.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DbUserRepository implements UserRepository {

    private final EntityManager em;

    @Override
    public User save(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public Optional<User> findById(String idxId) {
        User result = em.find(User.class, idxId);
        return Optional.ofNullable(result);
    }

    @Override
    public Optional<User> findByIdxId(Long idxId) {
        User result = em.find(User.class, idxId);
        return Optional.ofNullable(result);
    }
}
