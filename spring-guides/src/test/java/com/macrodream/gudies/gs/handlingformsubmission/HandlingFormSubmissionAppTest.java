package com.macrodream.gudies.gs.handlingformsubmission;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(GreetingController.class)
@TestPropertySource(properties = "logging.level.org.springframework.web=DEBUG")
public class HandlingFormSubmissionAppTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void rendersForm() throws Exception {
        mockMvc.perform(get("/greeting"))
                .andExpect(content().string(containsString("Form")));
    }

    @Test
    public void submitsForm() throws Exception{
        mockMvc.perform(post("/greeting").param("id","12345").param("content","Hello"))
                .andExpect(content().string(containsString("Result")))
                .andExpect(content().string(containsString("id: 12345")));
    }
}
