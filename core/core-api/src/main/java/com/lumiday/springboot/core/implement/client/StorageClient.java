package com.lumiday.springboot.core.implement.client;

import java.io.InputStream;

public interface StorageClient {

    void uploadToStorage(InputStream inputStream, long size, String fileName, String bucketName, String contentType);

    void deleteFromStorage(String bucketName, String fileName);

    byte[] downloadFromStorage(String bucketName, String fileName);
}
