package com.Dumbass.RouletteofAkashicRecords.controller.subject;

import com.Dumbass.RouletteofAkashicRecords.ControllerTestSetting;
import com.Dumbass.RouletteofAkashicRecords.controller.subject.dto.SubjectRemoveRequest;
import com.Dumbass.RouletteofAkashicRecords.controller.subject.dto.SubjectSaveRequest;
import com.Dumbass.RouletteofAkashicRecords.domain.Subject;
import com.Dumbass.RouletteofAkashicRecords.repository.subject.SubjectRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

class SubjectControllerTest extends ControllerTestSetting {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private SubjectRepository subjectRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void saveSubject() throws Exception {
        String content = "test";
        SubjectSaveRequest request = new SubjectSaveRequest(content);
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/subject/save")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)
        );

        String id = response.andReturn().getResponse().getContentAsString();
        Subject subject = subjectRepository.findById(Long.parseLong(id));

        response.andExpect(MockMvcResultMatchers.status().isCreated());
        Assertions.assertThat(subject.getContent()).isEqualTo(content);
    }

    @Test
    void saveSubjectBlank() throws Exception {
        String content = "   ";
        SubjectSaveRequest request = new SubjectSaveRequest(content);
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/subject/save")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)
        );

        response.andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    void saveSubjectEmpty() throws Exception {
        String content = "";
        SubjectSaveRequest request = new SubjectSaveRequest(content);
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/subject/save")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)
        );

        response.andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    void removeSubject() throws Exception {
        String content = "test";
        Subject subject = new Subject(content, null);
        Long id = subjectRepository.save(subject);

        SubjectRemoveRequest request = new SubjectRemoveRequest(id);

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/subject/remove")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)
        );

        response.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
        Assertions.assertThat(subjectRepository.findById(id)).isNull();
    }

}