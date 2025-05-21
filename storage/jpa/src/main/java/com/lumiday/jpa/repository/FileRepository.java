package com.lumiday.jpa.repository;

import com.lumiday.jpa.entity.FileEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, Long> {

    Optional<FileEntity> findBySavedFileName(String imageName);
}
