package whoreads.backend.domain.book.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import whoreads.backend.domain.book.dto.BookRequest;
import whoreads.backend.domain.book.dto.BookResponse;
import whoreads.backend.domain.book.entity.Book;
import whoreads.backend.domain.book.service.AladinBookService;
import whoreads.backend.domain.book.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final AladinBookService aladinBookService;
    private final BookService bookService;

    @GetMapping
    public List<BookResponse> getAllBooks() {
        return List.of();
    }

    @GetMapping("/search")
    public List<BookResponse> searchBooks(@RequestParam String keyword) {
        return aladinBookService.searchBooks(keyword);
    }

    // 책 수동 등록 API + 중복 체크 포함
    @PostMapping
    public ResponseEntity<BookResponse> registerBook(@RequestBody BookRequest request) {
        // 1. 서비스가 중복 체크 후 저장(또는 조회)
        Book savedBook = bookService.registerBook(request.toEntity());

        // 2. 결과 반환
        return ResponseEntity.ok(BookResponse.from(savedBook));
    }
}