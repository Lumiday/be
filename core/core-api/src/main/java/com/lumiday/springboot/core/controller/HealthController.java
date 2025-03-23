package com.lumiday.springboot.core.controller;

import com.lumiday.core.enums.TestEnum;
import com.lumiday.jpa.ExampleEntity;
import com.lumiday.jpa.ExampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HealthController {

    private final ExampleRepository exampleRepository;

    @GetMapping("/health")
    public ResponseEntity<Object> health() {
        return ResponseEntity.ok(TestEnum.TEST);
    }

    @GetMapping("/health2")
    public ResponseEntity<Object> health2() {
        ExampleEntity entity = new ExampleEntity("test");
        exampleRepository.save(entity);
        return ResponseEntity.ok(entity);
    }
}

