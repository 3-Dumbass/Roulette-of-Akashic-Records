package com.Dumbass.RouletteofAkashicRecords.repository.subject;

import com.Dumbass.RouletteofAkashicRecords.domain.Subject;

public interface SubjectRepository {

    /**
     * 주제 저장
     * @param subject 주제 객체
     * @return 주제 객체의 id
     */
    Long save(Subject subject);

    /**
     * id 기반으로 주제 찾기
     * @param id 주제 객체의 id
     * @return 찾아진 주제
     */
    Subject findById(Long id);

    /**
     * id로 주제 삭제
     * @param id 삭제할 주제의 id
     */
    void deleteById(Long id);
}
