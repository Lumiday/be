package com.lumiday.springboot.core.implement.persistence;

import com.lumiday.core.enums.FileContentType;
import com.lumiday.jpa.entity.FileEntity;
import com.lumiday.jpa.repository.FileRepository;
import com.lumiday.springboot.core.implement.dto.FileInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class FilePersistence {

    private final FileRepository fileRepository;

    @Transactional
    public void saveFileInfo(String originalFileName, String savedFileName, String objectName,
                             FileContentType contentType, long size) {

        FileEntity fileEntity = FileEntity.builder()
                .originalFileName(originalFileName)
                .savedFileName(savedFileName)
                .objectName(objectName)
                .contentType(contentType)
                .size(size)
                .build();

        fileRepository.save(fileEntity);
    }

    @Transactional
    public void deleteFileInfo(String savedFileName) {
        fileRepository.deleteBySavedFileName(savedFileName);
    }

    public FileInfo findBySavedFileName(String imageName) {
        return fileRepository.findBySavedFileName(imageName)
                .map(FileInfo::fromEntity)
                .orElseThrow(() -> new RuntimeException("파일을 찾을 수 없습니다."));
    }
}
