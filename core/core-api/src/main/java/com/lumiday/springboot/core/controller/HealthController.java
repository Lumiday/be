package com.lumiday.springboot.core.controller;

import com.lumiday.core.enums.TestEnum;
import com.lumiday.jpa.ExampleEntity;
import com.lumiday.jpa.ExampleRepository;
import com.lumiday.jpa.ExampleService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HealthController {

    private final ExampleService exampleService;

    @GetMapping("/health")
    public ResponseEntity<Object> health() {
        return ResponseEntity.ok(TestEnum.TEST);
    }

    @GetMapping("/health2")
    public ResponseEntity<Object> health2() {
        ExampleEntity entity = exampleService.getExampleEntity(1L);
        return ResponseEntity.ok(entity);
    }
}

