package com.Dumbass.RouletteofAkashicRecords.controller.subject;

import com.Dumbass.RouletteofAkashicRecords.ControllerTestSetting;
import com.Dumbass.RouletteofAkashicRecords.controller.subject.dto.SubjectSaveDto;
import com.Dumbass.RouletteofAkashicRecords.repository.SubjectRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

class SubjectControllerTest extends ControllerTestSetting {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private SubjectController subjectController;
    @Autowired
    private SubjectRepository subjectRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void saveSubject() throws Exception {
        String content = "test";
        SubjectSaveDto request = new SubjectSaveDto(content);
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/subject/save")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)
        );

        response.andExpect(MockMvcResultMatchers.status().isCreated());
    }
}