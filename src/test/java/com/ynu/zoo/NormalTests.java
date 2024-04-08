package com.ynu.zoo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
public class NormalTests {
    @Test
    public void testRandom(){
        for (int i = 0; i < 10; i++) {
            System.out.println(new Random().nextInt(2));
        }
    }
}
