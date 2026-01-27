package whoreads.backend.domain.book.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import whoreads.backend.domain.book.entity.Book;
import whoreads.backend.domain.book.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;

    // 책 상세 조회
    public Book getBook(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("책을 찾을 수 없습니다."));
    }

    // 책 목록 조회
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // 어드민용 책 등록
    // 제목과 작가가 DB에 이미 있으면 저장하지 않고 기존 책 반환
    @Transactional
    public Book registerBook(Book book) {
        return bookRepository.findByTitleAndAuthorName(book.getTitle(), book.getAuthorName())
                .orElseGet(() -> bookRepository.save(book));
    }
}