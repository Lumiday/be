package com.lumiday.jpa.repository;

import com.lumiday.jpa.entity.WeddingDateEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeddingDateRepository extends JpaRepository<WeddingDateEntity, String> {
    Optional<WeddingDateEntity> findByInvitationId(String invitationId);
}
