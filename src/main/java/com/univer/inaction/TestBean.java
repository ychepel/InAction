package com.univer.inaction;

import org.springframework.stereotype.Component;

@Component
public class TestBean {

    private String testValue = "Hello world!";

    public void testMethod() {
        System.out.print("test");
    }

    public String getTestValue() {
        return testValue;
    }
}
