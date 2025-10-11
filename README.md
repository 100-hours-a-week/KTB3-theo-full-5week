# KTB3-theo-full-4week

## 4주차 과제

3주차 REST API 설계를 기반으로 API 개발

## 아키텍처 개요
```plsql
Client
  └─ HTTP (JSON, Bearer Token)
      ↓
[Interceptor]
  - Authorization: Bearer <JWT> 검증
  - OK → request.setAttribute("userId")
      ↓
[Controller]
  - DTO 검증
      ↓
[Service]      
  - 비즈니스 로직
  - 페이징 util 사용
      ↓
[Repository]   repository.(user|post).*
  - In-memory 저장소(LinkedHashMap) 접근
      ↓
[Entity]      
  - 도메인 상태/행위
      ↓
[Exception Handling] 
  - BusinessException → ErrorResponseEntity(JSON) 변환
```

## 패키지 레이어링
```plsql
com.example.KTB_4WEEK
├─ Interceptor/
│  ├─ auth/
│  │  └─ TokenAuthInterceptor.java        ← 요청 선처리(JWT 검증)
│  └─ config/
│     └─ WebMvcConfig.java               ← 인터셉터 등록/경로 패턴
│
├─ controller/
│  ├─ auth/AuthController.java           ← 로그인 등
│  ├─ user/PublicUserController.java     ← 회원 관련 API
│  └─ post/PublicPostController.java     ← 게시글/댓글 API
│
├─ dto/
│  ├─ request/
│  │  ├─ user/...                        ← 로그인/중복체크/수정 요청
│  │  └─ post/...                        ← 글/댓글 생성/수정 요청
│  └─ response/
│     ├─ common/(BaseResponse, ResponseMessage)
│     ├─ user/...
│     └─ post/... + comment/...
│
├─ service/
│  ├─ auth/TokenService.java             ← JWT 발급/검증(alg, typ, exp)
│  ├─ user/PublicUserService.java
│  └─ post/PublicPostService.java
│
├─ repository/
│  ├─ user/(UserRepository, PublicUserRepository)
│  └─ post/(PostRepository, PublicPostRepository)
│
├─ entity/
│  ├─ User.java
│  ├─ Post.java
│  ├─ Comment.java
│  └─ PostCategory.java
│
├─ exception/
│  ├─ handler/(GlobalExceptionHandler, ErrorResponseEntity, ErrorCode)
│  ├─ common/BusinessException.java
│  ├─ auth/UnAuthorizedException.java
│  ├─ user/...                           ← 이메일/닉네임/유저 관련 예외
│  └─ post/... + post/comment/...        ← 게시글/댓글 관련 예외
│
└─ util/
   ├─ DB.java                            ← 인메모리 DB(데이터 시드/관리)
   ├─ table/(UserTable, PostTable, CommentTable, Table)
   ├─ paginationPolicy/
   │  ├─ PaginationPolicy.java
   │  ├─ PostPaginationPolicy.java
   │  └─ CommentPaginationPolicy.java
   ├─ validator/(UserValidator, PostValidator, Validator)
   └─ DateTimePattern.java
```

## 공통 요청 처리 플로우
```plsql
Client
  └─ HTTP JSON 요청
      (예: POST /posts, PATCH /users/{id})
        │
        ▼
[Controller]
  1) JSON → Request DTO 바인딩
  2) (필요 시) path/query/header 값과 합쳐 서비스 입력값 구성
        │  (예: @RequestAttribute userId, @PathVariable id)
        ▼
[Service]
  3) Request DTO → Entity 변환(혹은 기존 Entity 로드 후 필드 갱신)
  4) Repository 호출로 저장/조회/수정 수행
  5) 결과 Entity 확보
  6) Entity → Response DTO 변환
        │
        ▼
[Controller]
  7) BaseResponse<Response DTO>로 감싸 응답 반환(200/201 등)
        │
        ▼
Client
  └─ JSON 수신 (message, data, timestamp)

```

### BaseResponse
```java
public class BaseResponse<T> {
    private int status;
    private String message;
    private T data;
    private String timestamp;
 }
```

### ResponseMessage
```java
public enum ResponseMessage {
    // USER
    LOGIN_SUCCESS("Login Success"),
    LOGOUT_SUCCESS("Logout Success"),
    // POST
    POST_REGISTER_SUCCESS("Post Register Success"),
    POSTS_LOAD_SUCCESS("Posts Load Success"),
    // COMMENT
    COMMENT_CREATE_SUCCESS("Comment Create Success"),
    COMMENT_LOAD_SUCCESS("Comment Load Success");
}
```

### Response
```plsql
{
    "status": 0,
    "message": "Login Success",
    "data": {
        "id": 1,
        "loginSuccess": true
    },
    "timestamp": "2025-10-12 00:03:50"
}
```
## 공통 예외처리 플로우
```plsql
[Service]   (에러가 발생하는 지점)
   └─ throw new SomeBusinessException();   // e.g., new UnAuthorizedException()

        ↓  (예외 전파)

[GlobalExceptionHandler] (@RestControllerAdvice)
   └─ handleBusinessException(BusinessException e, HttpServletRequest req)
        - ErrorCode ec = e.getErrorCode()
        - return ErrorResponseEntity.toResponseEntity(ec, req.getRequestURI())

        ↓  (ResponseEntity<ErrorResponseEntity> 생성)

[ErrorResponseEntity]
   └─ new ErrorResponseEntity(ec.getCode(), ec.getStatus(), ec.getMessage(), path)
   └─ ResponseEntity.status(ec.getStatus()).body(errorResponse)
        (HTTP 상태와 바디를 일관된 방식으로 클라이언트에 반환)
```

