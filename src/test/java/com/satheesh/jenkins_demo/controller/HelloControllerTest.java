package com.satheesh.jenkins_demo.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {

    private final HelloController helloController = new HelloController();

    @Test
    void shouldReturnHelloMessage() {
        String response = helloController.sayHello();

        Assertions.assertEquals("Hello from Jenkins!", response);
    }
}
