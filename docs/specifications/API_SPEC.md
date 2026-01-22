# 📝 API Specification: WhoReads

모든 API 응답은 공통 포맷을 따르며, 상세 명세는 Swagger를 참고합니다.

## 🌐 Common Information
- **Base URL**: `http://43.201.122.162`
- **Swagger UI**:
  - `http://localhost:8080/swagger-ui/index.html` (Local)
  - `http://43.201.122.162/swagger-ui/index.html` (Deployed)
- **Common Response Format**:
  ```json
  {
    "status": "200 OK",
    "data": { ... },
    "message": null
  }
  ```
