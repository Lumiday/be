package com.lumiday.jpa.repository;

import com.lumiday.jpa.entity.IntroLayoutEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntroLayoutRepository extends JpaRepository<IntroLayoutEntity, String> {
    Optional<IntroLayoutEntity> findByInvitationId(String invitationId);
}
