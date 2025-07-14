package com.lumiday.springboot.core.implement.persistence;

import com.lumiday.jpa.entity.UserEntity;
import com.lumiday.jpa.repository.UserRepository;
import com.lumiday.springboot.core.domain.UserDomain;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPersistence {

    private final UserRepository userRepository;

    public UserEntity mapToEntity(UserDomain userDomain) {
        return userRepository.findByEmail(userDomain.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("사용자를 찾을 수 없습니다."));
    }
}
