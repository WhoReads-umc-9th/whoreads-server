package whoreads.backend.domain.dna.enums;

import lombok.Getter;

@Getter
public enum GenreCode {

    LITERATURE("문학"),
    ESSAY("에세이/회고"),
    HUMANITIES("인문/철학"),
    SOCIETY("사회/역사"),
    SCIENCE("과학/기술"),
    BUSINESS("경제/경영/커리어"),
    SELF_HELP("자기계발/심리");

    private final String description;

    GenreCode(String description) {
        this.description = description;
    }
}
