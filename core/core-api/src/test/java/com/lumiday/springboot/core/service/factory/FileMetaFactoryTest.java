package com.lumiday.springboot.core.service.factory;

import static org.assertj.core.api.Assertions.assertThat;

import com.lumiday.springboot.core.service.dto.FileMeta;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

class FileMetaFactoryTest {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    @Test
    void 파일정보를_기반으로_FileMeta_객체를_생성한다() {
        //Given
        MockMultipartFile file = new MockMultipartFile("hello.mp3", "original.mp3", "audio/mpeg", "test".getBytes());

        //When
        FileMeta fileMeta = FileMetaFactory.from(file);

        //Then
        String today = LocalDate.now().format(DATE_PATTERN);

        assertThat(fileMeta.originalName()).isEqualTo("original.mp3");
        assertThat(fileMeta.uuidName()).endsWith(".mp3");
        assertThat(fileMeta.objectName()).startsWith(today + "/");
        assertThat(fileMeta.extension()).isEqualTo("mp3");
        assertThat(fileMeta.contentType().getMimeType()).isEqualTo("audio/mpeg");
    }

    @Test
    void ContentType가_지원하지_않는_형식이면_에러를_던진다() {
        //Given
        MockMultipartFile file = new MockMultipartFile("hello", "original.txt", "text/plain", "test".getBytes());
        //When & Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> FileMetaFactory.from(file), "지원하지 않는 파일 형식입니다.");
    }

    @Test
    void ContentType_뒤에_정보가_있으면_잘라낸다() {
        //Given
        MockMultipartFile file = new MockMultipartFile("hello", "original.mp3", "audio/mpeg; charset=utf-8",
                "test".getBytes());
        //When
        FileMeta fileMeta = FileMetaFactory.from(file);
        //Then
        assertThat(fileMeta.contentType().getMimeType()).isEqualTo("audio/mpeg");
    }

    @Test
    void 파일확장자가_없으면_에러를_던진다() {
        //Given
        MockMultipartFile file = new MockMultipartFile("hello", "original", "audio/mpeg", "test".getBytes());
        //When & Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> FileMetaFactory.from(file), "파일 확장자가 없습니다.");
    }

    @Test
    void 파일이름이_없으면_에러를_던진다() {
        //Given
        MockMultipartFile file = new MockMultipartFile("hello", "", "audio/mpeg", "test".getBytes());
        //When & Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> FileMetaFactory.from(file), "파일 이름이 없습니다.");
    }
}