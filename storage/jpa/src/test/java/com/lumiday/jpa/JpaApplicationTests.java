package com.lumiday.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = TestApplication.class)
@ActiveProfiles("test")
class JpaApplicationTests {

    @Test
    void contextLoads() {
    }

}
