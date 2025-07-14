package com.lumiday.jpa.repository;

import com.lumiday.jpa.entity.PersonInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonInfoRepository extends JpaRepository<PersonInfoEntity, String> {
}
