package com.project.employeemanager.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UrlValidatorTest {

    private UrlValidator validatorTest;

    @BeforeEach
    void setUp() {
        validatorTest = new UrlValidator();
    }

    @Test
    void validateUrl(){
        String url = "http://dummyimage.com/242x100.png/5fa2dd/ffffff";

        boolean isValid = validatorTest.test(url);

        assertThat(isValid).isTrue();
    }

}
