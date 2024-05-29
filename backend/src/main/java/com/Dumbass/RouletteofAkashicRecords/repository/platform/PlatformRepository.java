package com.Dumbass.RouletteofAkashicRecords.repository.platform;


import com.Dumbass.RouletteofAkashicRecords.domain.Platform;

public interface PlatformRepository {
    /**
     * 플랫폼 저장
     * @param subject 플랫폼 객체
     * @return 플랫폼 객체의 id
     */
    Long save(Platform platform);

    /**
     * id 기반으로 플랫폼 찾기
     * @param id 플랫폼 객체의 id
     * @return 찾아진 플랫폼
     */
    Platform findById(Long id);

    /**
     * id로 플랫폼 삭제
     * @param id 삭제할 플랫폼의 id
     */
    void deleteById(Long id);
}
