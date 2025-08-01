package com.lumiday.jpa.repository;

import com.lumiday.jpa.entity.ThemeStyleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends JpaRepository<ThemeStyleEntity, String> {
}
