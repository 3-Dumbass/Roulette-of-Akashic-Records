package com.Dumbass.RouletteofAkashicRecords.repository.platform;

import com.Dumbass.RouletteofAkashicRecords.domain.Platform;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DbPlatformRepository implements PlatformRepository{

    private final EntityManager em;

    @Override
    public Long save(Platform platform) {
        em.persist(platform);
        return platform.getId();
    }

    @Override
    public Platform findById(Long id) {
        return em.find(Platform.class,id);
    }

    @Override
    public void deleteById(Long id) {
        Platform del = em.find(Platform.class, id);
        em.remove(del);
    }
}
