package com.lumiday.springboot.core.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import com.lumiday.springboot.core.config.MinioConfig;
import com.lumiday.springboot.core.implement.client.StorageClient;
import com.lumiday.springboot.core.implement.persistence.FilePersistence;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;

@ExtendWith(MockitoExtension.class)
class AudioServiceTest {
    @Mock
    private StorageClient storageClient;

    @Mock
    private FilePersistence filePersistence;

    @Mock
    private MinioConfig minioConfig;

    @Mock
    private MultipartFile file;

    @InjectMocks
    private AudioService audioService;

    @Test
    void 정상_오디오_업로드() throws IOException {
        //Given
        String fileName = "test.mp3";
        String contentType = "audio/mpeg";
        long fileSize = 1024;

        given(file.getOriginalFilename()).willReturn(fileName);
        given(file.getContentType()).willReturn(contentType);
        given(file.getSize()).willReturn(fileSize);
        given(file.getInputStream()).willReturn(new ByteArrayInputStream("data".getBytes()));
        given(minioConfig.getAudioBucket()).willReturn("test-bucket");
        //When
        String uuid = audioService.saveFile(file);
        //Then
        assertThat(uuid).isNotNull();
        verify(storageClient).uploadToStorage(
                eq(file.getInputStream()),
                eq(fileSize),
                any(),
                eq("test-bucket"),
                eq(contentType));
        verify(filePersistence).saveFileInfo(
                eq(fileName),
                eq(uuid),
                any(),
                any(),
                eq(fileSize));
    }

    @Test
    void 지원하지_않는_파일_형식_업로드_시_에러_발생() {
        //Given
        String fileName = "invalid.txt";
        String contentType = "invalid/type";
        long fileSize = 1024;

        given(file.getOriginalFilename()).willReturn(fileName);
        given(file.getContentType()).willReturn(contentType);
        given(file.getSize()).willReturn(fileSize);
        //When Then
        assertThatThrownBy(() -> audioService.saveFile(file)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("지원하지 않는 파일 형식입니다.");
    }

    @Test
    void 파일이_비어있을_경우_에러_발생() {
        //Given
        given(file.isEmpty()).willReturn(true);
        //When Then
        assertThatThrownBy(() -> audioService.saveFile(file)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("파일이 비어 있습니다.");
    }

    @Test
    void 파일_용량이_설정을_넘을_경우_에러_발생() {
        //Given
        given(file.getSize()).willReturn(audioService.maxSizeBytes() + 1);
        //When Then
        assertThatThrownBy(() -> audioService.saveFile(file)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("파일 용량은 20MB를 초과할 수 없습니다.");
    }

    // TODO 정상 삭제 및 조회 테스트 추가 (FixtureMonkey 로 테스트 데이터 생성 필요)
}