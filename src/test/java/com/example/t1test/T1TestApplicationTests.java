package com.example.t1test;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class T1TestApplicationTests {
    private final TestService testService = new TestService();


    @Test
    void contextLoads() {
        String result = String.valueOf(testService.findResult("aassdd"));

        Assertions.assertEquals(result,"{a=2, s=2, d=2}");
    }

    @Test
    void contextLoads_hard() {
        String result = String.valueOf(testService.findResult("basssavdуddsggcыggsdеdvьvvv"));

        Assertions.assertEquals(result,"{s=5, d=5, v=5, g=4, a=2, b=1, у=1, c=1, е=1, ы=1, ь=1}");
    }
}
