package whoreads.backend.domain.celebrity.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import whoreads.backend.global.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "celebrity")
public class Celebrity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50) // 이름 좀 길 수도 있으니 50
    private String name;

    @Column(name = "image_url", columnDefinition = "TEXT")
    private String imageUrl;

    @Column(name = "short_bio", nullable = false)
    private String shortBio;

    @Column(name = "one_line_introduction")
    private String oneLineIntroduction;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "celebrity_tags",          // 1. 자동으로 생길 테이블 이름
            joinColumns = @JoinColumn(name = "celebrity_id") // 2. 연결 고리(FK)
    )
    @Enumerated(EnumType.STRING)          // 3. DB에 "ACTOR", "SINGER" 글자로 저장
    @Column(name = "tag")                 // 4. 저장될 컬럼명
    private List<CelebrityTag> tags = new ArrayList<>(); // List로 관리!

    @Builder
    public Celebrity(String name, String imageUrl, String shortBio, List<CelebrityTag> tags) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.shortBio = shortBio;
        this.oneLineIntroduction = oneLineIntroduction;
        this.tags = (tags != null) ? tags : new ArrayList<>();
    }
}