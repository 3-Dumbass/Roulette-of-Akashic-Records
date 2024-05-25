package com.Dumbass.RouletteofAkashicRecords.repository.choice;

import com.Dumbass.RouletteofAkashicRecords.domain.Subject;

import java.util.ArrayList;

public interface ChoiceRepository {

    /**
     * 주제 랜덤 뽑기
     * @return 뽑은 주제*/
    Subject findSubject();

}
