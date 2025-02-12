package k25.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import k25.bookstore.domain.Book;
import k25.bookstore.domain.BookRepository;

@RestController
public class BookRestController {

    private BookRepository repository;

    public BookRestController(BookRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> bookListRest() {
        return (List<Book>) repository.findAll();
        // to do: lisää virheenkäsittely
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
        return repository.findById(bookId);
    }

}
