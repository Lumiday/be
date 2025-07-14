package com.lumiday.jpa.repository;

import com.lumiday.jpa.entity.InvitationMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvitationMessageRepository extends JpaRepository<InvitationMessageEntity, String> {
}
