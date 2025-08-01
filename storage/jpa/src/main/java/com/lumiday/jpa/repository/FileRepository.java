package com.lumiday.jpa.repository;

import com.lumiday.jpa.entity.FileEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, String> {

    Optional<FileEntity> findBySavedFileName(String imageName);
}
