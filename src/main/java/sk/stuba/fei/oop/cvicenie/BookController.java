package sk.stuba.fei.oop.cvicenie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/bookController")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/getBook/{id}")
    public Book getBook(
            @PathVariable("id") Long id
    ) {
        return bookService.getBook(id);
    }

    @PostMapping("/createNewBook")
    public Long createNewBook(
            @RequestBody BookRequest bookRequest
    ) {
        return bookService.createNewBook(bookRequest);
    }

    @PutMapping("/updateBook/{id}")
    public Book updateBook(
            @PathVariable("id") Long id,
            @RequestBody BookRequest bookRequest
    ) {
        return bookService.updateBook(id, bookRequest);
    }

    @DeleteMapping("/deleteBook/{id}")
    public Book deleteBook(
            @PathVariable("id") Long id
    ) {
        return bookService.deleteBook(id);
    }
}
