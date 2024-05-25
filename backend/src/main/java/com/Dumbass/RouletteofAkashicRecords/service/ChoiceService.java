package com.Dumbass.RouletteofAkashicRecords.service;

import com.Dumbass.RouletteofAkashicRecords.controller.choice.dto.SubjectChoiceDto;
import com.Dumbass.RouletteofAkashicRecords.domain.Subject;
import com.Dumbass.RouletteofAkashicRecords.repository.choice.ChoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ChoiceService {

    private final ChoiceRepository choiceRepository;

    public Subject choiceSubject(){

        return choiceRepository.findSubject();
    }

}
