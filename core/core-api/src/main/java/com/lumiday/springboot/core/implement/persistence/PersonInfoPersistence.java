package com.lumiday.springboot.core.implement.persistence;

import com.lumiday.jpa.repository.PersonInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonInfoPersistence {

    private final PersonInfoRepository personInfoRepository;
}
