package k25.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import k25.bookstore.domain.Book;
import k25.bookstore.domain.BookRepository;
import k25.bookstore.domain.Category;
import k25.bookstore.domain.CategoryRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTests {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findBooksShouldReturnAtLeastOneBook() throws Exception {
        assertThat(bookRepository.count()).isGreaterThan(0);
    }

    // Tallennuksen testaus
    @Test
    public void saveBook() throws Exception {
        Book book = new Book("Testi", "Testaaja", 2021, "123-456-789", 10.0, null);
        bookRepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void saveCategory() throws Exception {
        Category category = new Category("Testi");
        categoryRepository.save(category);
        assertThat(category.getCategoryid()).isNotNull();
    }

    @Test
    public void getCorrectData() {
        List<Book> books = bookRepository.findByTitle("Testi");
        assertThat(books).hasSize(1);
    }

    @Test
    public void getCorrectCategory() {
        List<Category> categories = categoryRepository.findByName("Testi");
        assertThat(categories).hasSize(1);
    }

    @Test
    public void deleteBook() {
        List<Book> books = bookRepository.findByTitle("Testi");
        Book book = books.get(0);
        bookRepository.delete(book);
        List<Book> newBooks = bookRepository.findByTitle("Testi");
        assertThat(newBooks).hasSize(0);
    }

    @Test
    public void deleteCategory() {
        List<Category> categories = categoryRepository.findByName("Testi");
        Category category = categories.get(0);
        categoryRepository.delete(category);
        List<Category> newCategories = categoryRepository.findByName("Testi");
        assertThat(newCategories).hasSize(0);
    }

}
