package com.lumiday.jpa.repository;

import com.lumiday.jpa.entity.PersonBaseInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonBaseInfoRepository extends JpaRepository<PersonBaseInfoEntity, String> {
}
