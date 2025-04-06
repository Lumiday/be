package com.lumiday.springboot.core.controller;

import com.lumiday.springboot.core.service.ImageService;
import com.lumiday.springboot.core.service.dto.ImageWithType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/file")
public class ImageController {

    private final ImageService imageService;

    @Operation(summary = "이미지 업로드", description = "이미지를 업로드합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "업로드 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청"),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> upload(
            @Parameter(description = "업로드할 파일", required = true)
            @RequestPart("image") MultipartFile file) throws IOException {

        String uploadedFileName = imageService.saveImage(file);
        return ResponseEntity.ok(uploadedFileName);
    }

    @Operation(summary = "이미지 삭제", description = "이미지를 삭제합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "업로드 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청"),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String imageName) {
        imageService.deleteImage(imageName);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "이미지 조회", description = "이미지를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청"),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    @GetMapping
    public ResponseEntity<byte[]> getImage(@RequestParam String imageName) {
        ImageWithType image = imageService.getImage(imageName);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image.data());
    }
}

