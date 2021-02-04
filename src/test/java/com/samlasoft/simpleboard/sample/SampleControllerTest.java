package com.samlasoft.simpleboard.sample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {"spring.config.location=classpath:application-test.yml"})
@AutoConfigureMockMvc
class SampleControllerTest {

    @Test
    void exampleTest(@Autowired MockMvc mvc) throws Exception {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.of(LocalTime.now().getHour(),LocalTime.now().getMinute(),LocalTime.now().getSecond());
        mvc.perform(get("/api/v1/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"name\":\"samlak\",\"hello\":\"Hello\",\"date\":\"" +date+ "\",\"time\":\"" +time+ "\"}"));
    }

}