package com.lumiday.jpa.repository;

import com.lumiday.jpa.entity.PersonInfoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonInfoRepository extends JpaRepository<PersonInfoEntity, String> {
    List<PersonInfoEntity> findAllByInvitationId(String invitationId);
}
