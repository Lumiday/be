package com.lumiday.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExampleService {

    private final ExampleRepository exampleRepository;

    public ExampleEntity getExampleEntity(Long id) {
        return exampleRepository.findById(id).orElse(null);
    }

    public ExampleEntity saveExampleEntity(ExampleEntity exampleEntity) {
        return exampleRepository.save(exampleEntity);
    }

    public void deleteExampleEntity(Long id) {
        exampleRepository.deleteById(id);
    }

}
