package whoreads.backend.domain.dna.entity;

import jakarta.persistence.*;
import lombok.*;
import whoreads.backend.domain.dna.enums.GenreCode;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Table
public class DnaAnswer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private GenreCode genreCode;

    @Column(nullable = false)
    private int score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "track_id")
    private DnaTrack dnaTrack;
}
