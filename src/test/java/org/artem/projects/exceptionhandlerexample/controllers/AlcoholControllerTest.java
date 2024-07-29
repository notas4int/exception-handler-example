package org.artem.projects.exceptionhandlerexample.controllers;

import org.artem.projects.exceptionhandlerexample.exceptions.BeerNotFoundException;
import org.artem.projects.exceptionhandlerexample.exceptions.DetectedLiverCirrhosisException;
import org.artem.projects.exceptionhandlerexample.exceptions.PoorWineQualityException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AlcoholControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldReturnExceptionResponse_AfterCheckBeer() throws Exception {
        var request = get("/beer");

        mockMvc.perform(request).andExpectAll(
                result -> assertInstanceOf(BeerNotFoundException.class, result.getResolvedException()),
                status().isNotFound(),
                jsonPath("$.requestURI").value("/beer"),
                jsonPath("$.message").value("Beer is not found(("),
                jsonPath("$.currentTime").exists()
        );
    }

    @Test
    void shouldReturnExceptionResponse_AfterCheckWine() throws Exception {
        var request = get("/wine");

        mockMvc.perform(request).andExpectAll(
                result -> assertInstanceOf(PoorWineQualityException.class, result.getResolvedException()),
                status().isBadRequest(),
                jsonPath("$.requestURI").value("/wine"),
                jsonPath("$.message").value("Wine is not good(("),
                jsonPath("$.currentTime").exists()
        );
    }

    @Test
    void shouldReturnExceptionResponse_AfterCheckHealth() throws Exception {
        var request = get("/health");

        mockMvc.perform(request).andExpectAll(
                result -> assertInstanceOf(DetectedLiverCirrhosisException.class, result.getResolvedException()),
                status().isForbidden(),
                jsonPath("$.requestURI").value("/health"),
                jsonPath("$.message").value("Cirrhosis is detected(( so sorry<3"),
                jsonPath("$.currentTime").exists()
        );
    }
}