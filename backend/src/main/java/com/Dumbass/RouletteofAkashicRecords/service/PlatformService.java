package com.Dumbass.RouletteofAkashicRecords.service;

import com.Dumbass.RouletteofAkashicRecords.domain.Platform;
import com.Dumbass.RouletteofAkashicRecords.domain.User;
import com.Dumbass.RouletteofAkashicRecords.repository.platform.PlatformRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PlatformService {

    private final PlatformRepository platformRepository;

    public Long savePlatform(String content, User user){
        Platform platform = new Platform(content, user);
        return platformRepository.save(platform);
    }

    public void deleteSubject(Long id){
        platformRepository.deleteById(id);
    }
}
