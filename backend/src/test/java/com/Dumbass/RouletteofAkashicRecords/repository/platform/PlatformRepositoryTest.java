package com.Dumbass.RouletteofAkashicRecords.repository.platform;

import com.Dumbass.RouletteofAkashicRecords.SpringTestSetting;
import com.Dumbass.RouletteofAkashicRecords.domain.Platform;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

class PlatformRepositoryTest extends SpringTestSetting {

    @Autowired
    private PlatformRepository platformRepository;

    @Test
    void save() {
        Platform platform = new Platform("test", null);
        Long id = platformRepository.save(platform);

        Platform find = platformRepository.findById(id);
        Assertions.assertThat(find).isSameAs(platform);
        Assertions.assertThat(find.getCreateDate()).isBefore(LocalDateTime.now());
    }

    @Test
    void deleteById() {
        Platform platform = new Platform("test", null);
        Long id = platformRepository.save(platform);
        Assertions.assertThat(platformRepository.findById(id)).isSameAs(platform);

        platformRepository.deleteById(id);
        Assertions.assertThat(platformRepository.findById(id)).isNull();
    }
}