package k25.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k25.bookstore.domain.AppUser;
import k25.bookstore.domain.Book;
import k25.bookstore.domain.BookRepository;
import k25.bookstore.domain.Category;
import k25.bookstore.domain.CategoryRepository;
import k25.bookstore.domain.AppUserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository,
			AppUserRepository urepository) {
		return (args) -> {

			// save a couple of categories
			Category category1 = new Category("Fiction");
			Category category2 = new Category("Non-Fiction");

			crepository.save(category1);
			crepository.save(category2);

			// save a couple of books
			repository.save(new Book("1984", "George Orwell", 1949, "123-456-789", 10.0, category1));
			repository.save(new Book("Brave New World", "Aldous Huxley", 1932, "987-654-321", 12.0, category1));
			repository.save(new Book("Fahrenheit 451", "Ray Bradbury", 1953, "321-654-987", 11.0, category1));
			repository.save(new Book("Nexus", "Noah Harari", 2014, "654-321-987", 15.0, category2));

			// Create users: admin/admin user/user
			AppUser user1 = new AppUser("user", "$2a$10$EY1L6HC672X2i.1HgFsaheQncKBFJuK5o85KdOwlISXrmHovlX3GO", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$CSwyw8VBNrPKStUVXB1p2e5hgGOgcQUwFXQ4b8CDfc4SILb5Mxd3K",
					"ADMIN");
			urepository.save(user1);
			urepository.save(user2);
		};
	}

}
