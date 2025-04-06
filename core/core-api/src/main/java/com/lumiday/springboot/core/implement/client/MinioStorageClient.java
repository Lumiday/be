package com.lumiday.springboot.core.implement.client;

import com.lumiday.springboot.core.config.MinioConfig;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import java.io.InputStream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MinioStorageClient implements StorageClient {

    private final MinioClient minioClient;
    private final MinioConfig minioConfig;

    @Override
    public void uploadToStorage(InputStream inputStream, long size, String fileName,
                                String contentType) {
        try {
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(minioConfig.getBucket())
                            .object(fileName)
                            .stream(inputStream, size, -1)
                            .contentType(contentType)
                            .build()
            );
        } catch (Exception e) {
            throw new RuntimeException("Minio 파일 업로드 실패", e);
        }
    }

    @Override
    public void deleteFromStorage(String fileName) {
        try {
            minioClient.removeObject(
                    RemoveObjectArgs.builder()
                            .bucket(minioConfig.getBucket())
                            .object(fileName)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException("Minio 파일 삭제 실패", e);
        }
    }

    @Override
    public byte[] downloadFromStorage(String objectName) {
        try {
            InputStream inputStream = minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(minioConfig.getBucket())
                            .object(objectName)
                            .build()
            );

            return inputStream.readAllBytes();
        } catch (Exception e) {
            throw new RuntimeException("Minio 파일 가져오기 실패", e);
        }
    }
}
