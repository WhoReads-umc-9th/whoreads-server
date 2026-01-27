package whoreads.backend.domain.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whoreads.backend.domain.book.entity.BookQuote;

import java.util.List;

public interface BookQuoteRepository extends JpaRepository<BookQuote, Long> {

    // 1. 책 기준 - 이 책에 달린 인용들 가져오기 (맥락 점수 높은 순)
    List<BookQuote> findByBookIdOrderByQuoteContextScoreDesc(Long bookId);

    // 2. 인물 기준 - 이 사람이 남긴 인용들 가져오기 (맥락 점수 높은 순)
    List<BookQuote> findByQuote_Celebrity_IdOrderByQuoteContextScoreDesc(Long celebrityId);
}