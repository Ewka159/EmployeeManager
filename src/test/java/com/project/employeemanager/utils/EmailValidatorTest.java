package com.project.employeemanager.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailValidatorTest {

    private EmailValidator validatorTest;

    @BeforeEach
    void setUp() {
        validatorTest = new EmailValidator();
    }

    @Test
    void validateEmail(){
        String email = "jkhfwjfhl@gmail.com";

        boolean isValid = validatorTest.test(email);

        assertThat(isValid).isTrue();
    }

}
