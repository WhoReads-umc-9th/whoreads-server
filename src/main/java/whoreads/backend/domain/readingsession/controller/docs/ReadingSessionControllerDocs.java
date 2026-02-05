package whoreads.backend.domain.readingsession.controller.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import whoreads.backend.domain.readingsession.dto.ReadingSessionRequest;
import whoreads.backend.domain.readingsession.dto.ReadingSessionResponse;
import whoreads.backend.global.response.ApiResponse;

@Tag(name = "Reading Session (독서 타임)", description = "독서 세션 타이머 API | by 쏘이/김서연")
public interface ReadingSessionControllerDocs {

    @Operation(
            summary = "독서 세션 시작",
            description = "새로운 독서 세션을 시작합니다. 첫 번째 인터벌이 자동으로 생성됩니다."
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "세션 시작 성공",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(value = """
                                    {
                                      "is_success": true,
                                      "code": 201,
                                      "message": "독서 세션을 시작했습니다.",
                                      "result": {
                                        "session_id": 1
                                      }
                                    }
                                    """)
                    )
            )
    })
    ResponseEntity<ApiResponse<ReadingSessionResponse.StartResult>> startSession(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "세션 시작 요청",
                    required = true,
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(value = """
                                    {
                                      "member_id": 1
                                    }
                                    """)
                    )
            )
            ReadingSessionRequest.Start request
    );

    @Operation(
            summary = "독서 세션 일시정지",
            description = "진행 중인 독서 세션을 일시정지합니다. 현재 인터벌이 종료됩니다."
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "일시정지 성공",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(value = """
                                    {
                                      "is_success": true,
                                      "code": 200,
                                      "message": "독서 세션을 일시정지했습니다."
                                    }
                                    """)
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "세션을 찾을 수 없음",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(value = """
                                    {
                                      "is_success": false,
                                      "code": 404,
                                      "message": "세션을 찾을 수 없습니다."
                                    }
                                    """)
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "400",
                    description = "잘못된 세션 상태",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(value = """
                                    {
                                      "is_success": false,
                                      "code": 400,
                                      "message": "진행 중인 세션만 일시정지할 수 있습니다."
                                    }
                                    """)
                    )
            )
    })
    ResponseEntity<ApiResponse<Void>> pauseSession(
            @Parameter(description = "세션 ID", required = true)
            Long sessionId
    );

    @Operation(
            summary = "독서 세션 재개",
            description = "일시정지된 독서 세션을 재개합니다. 새로운 인터벌이 생성됩니다."
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "재개 성공",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(value = """
                                    {
                                      "is_success": true,
                                      "code": 200,
                                      "message": "독서 세션을 재개했습니다."
                                    }
                                    """)
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "세션을 찾을 수 없음",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(value = """
                                    {
                                      "is_success": false,
                                      "code": 404,
                                      "message": "세션을 찾을 수 없습니다."
                                    }
                                    """)
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "400",
                    description = "잘못된 세션 상태",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(value = """
                                    {
                                      "is_success": false,
                                      "code": 400,
                                      "message": "일시정지된 세션만 재개할 수 있습니다."
                                    }
                                    """)
                    )
            )
    })
    ResponseEntity<ApiResponse<Void>> resumeSession(
            @Parameter(description = "세션 ID", required = true)
            Long sessionId
    );

    @Operation(
            summary = "독서 세션 완료",
            description = "독서 세션을 완료합니다. 모든 인터벌의 시간을 합산하여 총 독서 시간을 반환합니다."
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "완료 성공",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(value = """
                                    {
                                      "is_success": true,
                                      "code": 200,
                                      "message": "요청이 성공했습니다.",
                                      "result": {
                                        "session_id": 1,
                                        "status": "COMPLETED",
                                        "total_minutes": 45,
                                        "created_at": "2026-02-06T14:00:00",
                                        "finished_at": "2026-02-06T14:50:00",
                                        "intervals": [
                                          {
                                            "interval_id": 1,
                                            "start_time": "2026-02-06T14:00:00",
                                            "end_time": "2026-02-06T14:25:00",
                                            "duration_minutes": 25
                                          },
                                          {
                                            "interval_id": 2,
                                            "start_time": "2026-02-06T14:30:00",
                                            "end_time": "2026-02-06T14:50:00",
                                            "duration_minutes": 20
                                          }
                                        ]
                                      }
                                    }
                                    """)
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "세션을 찾을 수 없음",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(value = """
                                    {
                                      "is_success": false,
                                      "code": 404,
                                      "message": "세션을 찾을 수 없습니다."
                                    }
                                    """)
                    )
            )
    })
    ResponseEntity<ApiResponse<ReadingSessionResponse.SessionDetail>> completeSession(
            @Parameter(description = "세션 ID", required = true)
            Long sessionId
    );
}
