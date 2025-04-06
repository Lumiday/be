package com.lumiday.springboot.core.implement.client;

import java.io.InputStream;

public interface StorageClient {

    void uploadToStorage(InputStream inputStream, long size, String fileName, String contentType);

    void deleteFromStorage(String fileName);

    byte[] downloadFromStorage(String fileName);
}
