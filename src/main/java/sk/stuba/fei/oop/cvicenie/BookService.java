package sk.stuba.fei.oop.cvicenie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return(book.isPresent() ? book.get() : null);
    }

    public Long createNewBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setName(bookRequest.getName());
        bookRepository.save(book);
        return book.getId();
    }

    public Book updateBook(Long id, BookRequest bookRequest) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent() && !bookRequest.getName().isEmpty()) {
            book.get().setName(bookRequest.getName());
            bookRepository.save(book.get());
            return book.get();
        }
        return (book.isPresent() ? book.get() : null);
    }

    public Book deleteBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.delete(book.get());
        }
        return book.get();
    }
}
