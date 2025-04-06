# 🧱 프로젝트 아키텍처 개요

## 🧭 구조 개요

본 프로젝트는 명확한 계층 분리와 기술 종속 최소화를 목표로 다음과 같은 구조로 설계되었습니다.

```
┌────────────────────────────┐
│ Controller │ ← 사용자 요청 처리 및 응답
└────────────┬───────────────┘
             │
┌────────────▼───────────────┐
│ Service    │ ← 비즈니스 로직 조정 및 흐름 제어
└────────────┬───────────────┘
             │
┌────────────▼───────────────┐
│ Implement  │ ← 구체적인 작업 실행 (JPA, MinIO 등)
└────────────┬───────────────┘
             │
┌────────────▼───────────────┐
│ Repository │ ← 데이터 접근 및 영속성 관리
└────────────────────────────┘
```

---

## 🏷️ 계층별 책임 및 제약 사항

| 계층                   | 역할 설명                                       |
|----------------------|---------------------------------------------|
| **Controller Layer** | 사용자의 요청을 처리하고 응답을 반환합니다. DTO만 사용합니다.        |
| **Service Layer**    | 비즈니스 흐름을 조정하며, 여러 Implement를 조합할 수 있습니다.    |
| **Implement Layer**  | 외부 시스템(JPA, MinIO, 외부 API 등)과의 통신, 실제 처리 수행 |
| **Repository Layer** | JPA 기반 DB 접근을 담당합니다. Entity를 직접 다룹니다.       |

> 🔒 **제약사항**
> - 각 Layer는 **동일 Layer를 참조할 수 없습니다.**
    >   - ❌ 예: Service → 다른 Service 직접 참조 금지
> - 오직 **Implement Layer만** 다른 Implement를 참조할 수 있습니다.
> - JPA `Entity`는 오직 **Repository, Implement Layer 내부에서만 사용**하며 외부에는 `DTO`를 통해 전달합니다.

| 구현체 역할        | 네이밍 패턴 예시                     | 설명                                         |
|---------------|-------------------------------|--------------------------------------------|
| 외부 API 호출     | XxxClient                     | ex: MinioClient, KakaoMapClient            |
| 데이터 저장/읽기     | XxxStore 또는 XxxRepositoryImpl | JPA가 아닌 저장소 구현시 ex: FileStore, LogStore    |
| 복잡한 작업 처리     | XxxProcessor 또는 XxxExecutor   | ex: PdfExportProcessor, BatchJobExecutor   |
| 단순 위임/연동      | XxxAdapter                    | ex: EmailAdapter, SmsAdapter               |
| 직접 수행 (핵심 기능) | XxxHandler                    | ex: FileUploadHandler, TokenRefreshHandler |
| JPA 대체 저장소 구현 | XxxJpaStore 또는 XxxPersistence | JPA 사용하되, Entity 대신 DTO를 사용하는 구현체          |

---

## 🧱 멀티 모듈 구성

```
root-project
├── core-api
│   ├── controller/
│   ├── service/
│   ├── implement/
│   │   └── FilePersistence.java (예: JPA 구현체)
│   └── dto/
│       └── FileInfo.java
│
├── storage
│   ├── entity/
│   │   └── FileEntity.java
│   └── repository/
│       └── FileRepository.java
```

- `core-api`는 비즈니스 흐름을 다루는 핵심 모듈입니다.
- `storage`는 JPA 기반의 Entity 및 Repository만 정의합니다.
- `core-api`는 `storage`에 의존하지만, `storage`는 `core-api`에 의존하지 않습니다.

---

## 🧩 예시: 파일 저장 흐름

```
Controller → Service → FilePersistence (Implement) → FileRepository
```

```java
// FileInfo DTO
public record FileInfo(
                Long id,
                String originalFileName,
                String savedFileName,
                String path,
                String contentType,
                Long size
        ) {
}

// FilePersistence
@Component
@RequiredArgsConstructor
public class FilePersistence {
    private final FileRepository repository;

    @Transactional
    public FileInfo saveFileInfo(...) {
        FileEntity entity = FileEntity.builder()...build();
        FileEntity saved = repository.save(entity);
        return FileInfo.from(saved);
    }
}
```

---

## 🧰 기술 전환 고려 사항

- JPA에서 jOOQ, MyBatis 등으로 변경 가능성을 염두에 두고 설계
- `FilePersistence`는 interface로 분리 가능:

```java
public interface FilePersistence {
    void saveFileInfo(...);

    void deleteFileInfo(...);
}
```

- 구현체는 별도로 유지:

```java

@Component
public class JpaFilePersistence implements FilePersistence {
    // JPA 기반 구현
}
```
