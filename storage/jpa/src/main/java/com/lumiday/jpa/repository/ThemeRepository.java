package com.lumiday.jpa.repository;

import com.lumiday.jpa.entity.ThemeStyleEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<ThemeStyleEntity, String> {
    Optional<ThemeStyleEntity> findByInvitationId(String invitationId);
}
