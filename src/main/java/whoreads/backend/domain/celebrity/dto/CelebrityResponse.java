package whoreads.backend.domain.celebrity.dto;

import lombok.Builder;
import lombok.Getter;
import whoreads.backend.domain.celebrity.entity.Celebrity;
import whoreads.backend.domain.celebrity.entity.CelebrityTag;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class CelebrityResponse {
    private Long id;
    private String name;
    private String imageUrl;
    private String shortBio;
    private List<String> tags; // "SINGER", "ACTOR" 처럼 배열로 받음

    public static CelebrityResponse from(Celebrity celebrity) {
        return CelebrityResponse.builder()
                .id(celebrity.getId())
                .name(celebrity.getName())
                .imageUrl(celebrity.getImageUrl())
                .shortBio(celebrity.getShortBio())
                .tags(
                        celebrity.getTags().stream()        // 1. 리스트를 펼쳐서
                                .map(CelebrityTag::getDescription)       // 2. 각각의 한글 설명만 뽑고
                                .collect(Collectors.toList())   // 3. 다시 리스트로 묶기
                )
                .build();
    }
}