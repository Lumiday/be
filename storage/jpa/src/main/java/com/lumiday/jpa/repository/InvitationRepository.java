package com.lumiday.jpa.repository;

import com.lumiday.jpa.entity.InvitationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvitationRepository extends JpaRepository<InvitationEntity, String> {
}
