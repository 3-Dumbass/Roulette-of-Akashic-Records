package com.Dumbass.RouletteofAkashicRecords.controller.platform;

import com.Dumbass.RouletteofAkashicRecords.ControllerTestSetting;
import com.Dumbass.RouletteofAkashicRecords.controller.platform.dto.PlatformRemoveRequest;
import com.Dumbass.RouletteofAkashicRecords.controller.platform.dto.PlatformSaveRequest;
import com.Dumbass.RouletteofAkashicRecords.domain.Platform;
import com.Dumbass.RouletteofAkashicRecords.repository.platform.PlatformRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


class PlatformControllerTest extends ControllerTestSetting {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PlatformRepository platformRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void savePlatform() throws Exception {
        String content = "test";
        PlatformSaveRequest request = new PlatformSaveRequest(content);
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/platform/save")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)
        );

        String id = response.andReturn().getResponse().getContentAsString();
        Platform platform = platformRepository.findById(Long.parseLong(id));

        response.andExpect(MockMvcResultMatchers.status().isCreated());
        Assertions.assertThat(platform.getContent()).isEqualTo(content);
    }

    @Test
    void savePlatformBlank() throws Exception {
        String content = "  ";
        PlatformSaveRequest request = new PlatformSaveRequest(content);
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/platform/save")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)
        );
        response.andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    void savePlatformEmpty() throws Exception {
        String content = "";
        PlatformSaveRequest request = new PlatformSaveRequest(content);
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/platform/save")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)
        );
        response.andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    void removeSubject() throws Exception {
        String content = "test";
        Platform platform = new Platform(content, null);
        Long id = platformRepository.save(platform);

        PlatformRemoveRequest request = new PlatformRemoveRequest(id);

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/platform/remove")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)
        );


        response.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
        Assertions.assertThat(platformRepository.findById(id)).isNull();
    }
}