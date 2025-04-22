package com.lumiday.springboot.core.service;

import com.lumiday.core.enums.FileContentType;
import com.lumiday.springboot.core.config.MinioConfig;
import com.lumiday.springboot.core.implement.client.StorageClient;
import com.lumiday.springboot.core.implement.persistence.FilePersistence;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AudioService extends BaseFileService {

    private static final List<String> ALLOWED_MUSIC_TYPE = List.of("audio/mpeg");
    private static final long MAX_FILE_SIZE = 20 * 1024 * 1024;
    private final MinioConfig minioConfig;

    public AudioService(StorageClient storageClient, FilePersistence filePersistence, MinioConfig minioConfig) {
        super(storageClient, filePersistence);
        this.minioConfig = minioConfig;
    }

    @Override
    protected String bucketName() {
        return minioConfig.getAudioBucket();
    }

    @Override
    protected long maxSizeBytes() {
        return MAX_FILE_SIZE;
    }

    @Override
    protected boolean isSupported(FileContentType contentType) {
        return contentType.isAudio();
    }
}
