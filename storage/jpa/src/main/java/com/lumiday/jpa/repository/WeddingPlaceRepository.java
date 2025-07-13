package com.lumiday.jpa.repository;

import com.lumiday.jpa.entity.WeddingPlaceEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeddingPlaceRepository extends JpaRepository<WeddingPlaceEntity, String> {
    Optional<WeddingPlaceEntity> findByInvitationId(String invitationId);
}
