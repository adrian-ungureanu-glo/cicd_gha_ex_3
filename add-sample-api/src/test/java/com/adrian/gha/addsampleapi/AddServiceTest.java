package com.adrian.gha.addsampleapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AddServiceTest {
    
        @Test
        public void testAdd() {
            AddService addService = new AddService();
            int result = addService.add(1, 2);
            assertEquals(3, result);
        }
}
