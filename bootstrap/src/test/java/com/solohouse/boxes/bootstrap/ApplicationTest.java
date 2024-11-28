package com.solohouse.boxes.bootstrap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void when_application_starts_context_loads() {
        assertThat(applicationContext).isNotNull();
    }
}