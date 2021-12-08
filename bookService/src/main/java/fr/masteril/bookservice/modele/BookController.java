package fr.masteril.bookservice.modele;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Tabary
 */
@RestController
public class BookController {
    private final BookRepository dao;
    @Value("${me}")
    private String me;

    @Autowired
    BookController(BookRepository bookRepository){
        dao = bookRepository;
    }

    @GetMapping("/Books")
    public Iterable<Book> getAllBooks() {
        return dao.findAll();
    }

    @GetMapping("/Books/{author}")
    public Iterable<Book> getAllBooksByAuthor(@PathVariable String author) {
        return dao.findAllByAuthor(author);
    }

    @GetMapping("/Books/{id}")
    public Optional<Book> getBook(@PathVariable Long id) {
        return dao.findById(id);
    }

    @GetMapping("Books/{isbn}")
    public Optional<Book> getBook(@PathVariable String isbn) {
        return dao.findByIsbn(isbn);
    }

    @DeleteMapping("/Books/{id}")
    public void deleteById(@PathVariable Long id) {
        dao.deleteById(id);
    }

    @DeleteMapping("/Books/{isbn}")
    public void deleteByIsbn(@PathVariable String isbn) {
        dao.deleteByIsbn(isbn);
    }

    @GetMapping("/WhoIs")
    public String getMe(){
        return me;
    }
}
