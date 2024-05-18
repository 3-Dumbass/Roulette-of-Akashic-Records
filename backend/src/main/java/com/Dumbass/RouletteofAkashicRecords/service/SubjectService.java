package com.Dumbass.RouletteofAkashicRecords.service;

import com.Dumbass.RouletteofAkashicRecords.domain.Subject;
import com.Dumbass.RouletteofAkashicRecords.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public Long saveSubject(String content){
        Subject subject = new Subject(content);
        subjectRepository.save(subject);
        return subject.getId();
    }

    public void deleteSubject(Long id){
        subjectRepository.deleteById(id);
    }
}
