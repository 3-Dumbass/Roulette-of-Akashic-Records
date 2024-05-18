package com.Dumbass.RouletteofAkashicRecords.repository;

import com.Dumbass.RouletteofAkashicRecords.SpringTestSetting;
import com.Dumbass.RouletteofAkashicRecords.domain.Subject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

class SubjectRepositoryTest extends SpringTestSetting {

    @Autowired
    private SubjectRepository subjectRepository;
    @Test
    void save() {
        Subject subject = new Subject("test",null);

        Long id = subjectRepository.save(subject);

        Assertions.assertThat(subjectRepository.findById(id)).isSameAs(subject);
        Assertions.assertThat(subject.getCreateDate()).isBefore(LocalDateTime.now());
    }

    @Test
    void delete() {
        Subject subject = new Subject("test",null);

        Long id = subjectRepository.save(subject);
        Assertions.assertThat(subjectRepository.findById(id)).isSameAs(subject);
        subjectRepository.deleteById(id);

        Assertions.assertThat(subjectRepository.findById(id)).isNull();

    }
}