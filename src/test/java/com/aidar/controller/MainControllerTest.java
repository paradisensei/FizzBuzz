package com.aidar.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Aidar Shaifutdinov.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void mainShouldReturnValidStringResponseUponValidRequest() throws Exception {
        long number = 15;
        String expected = "FizzBuzz";
        mvc.perform(get("/" + number))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TEXT_PLAIN_VALUE + ";charset=UTF-8"))
                .andExpect(content().string(expected));
    }

    @Test
    public void mainShouldReturnErrorResponseUponInvalidRequest() throws Exception {
        String number = "fifteen";
        mvc.perform(get("/" + number))
                .andExpect(status().isBadRequest());
    }

}