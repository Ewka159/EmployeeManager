package com.project.employeemanager.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneNumberValidatorTest {

    private PhoneNumberValidator validatorTest;

    @BeforeEach
    void setUp() {
        validatorTest = new PhoneNumberValidator();
    }

    @Test
    void validatePhoneNumber(){
        String phoneNumber = "+48642378423";

        boolean isValid = validatorTest.test(phoneNumber);

        assertThat(isValid).isTrue();
    }

}
