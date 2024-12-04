package utb.fai.soapservice;

import com.example.book_web_service.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utb.fai.soapservice.Model.AuthorPersistent;
import utb.fai.soapservice.Model.BookPersistent;
import utb.fai.soapservice.Repository.AuthorRepository;
import utb.fai.soapservice.Repository.BookRepository;

/**
 * Servis obsahujici aplikacni logiky pro praci s daty (knihy a autori)
 */
@Service
public class LibraryService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorPersistent getAuthor(long authorId) {
        var author = authorRepository.findById(authorId);
        return author.orElse(null);

    }
    public BookPersistent getBook(long bookId) {
        var book = bookRepository.findById(bookId);
        return book.orElse(null);
    }

    public BookPersistent createBook(BookPersistent book) {
         authorRepository.save(book.getAuthor());
         bookRepository.save(book);
         return book;
    }

    public void deleteBook(long bookId) {
        bookRepository.deleteById(bookId);
    }

    public AuthorPersistent createAuthor(AuthorPersistent author) {
        authorRepository.save(author);
        return author;
    }

    public void deleteAuthor(long authorId) {
        var books = bookRepository.findAll();
        for (var book : books) {
            if (book.getAuthor().getId() == authorId) {
                bookRepository.deleteById(book.getId());
            }
        }
        authorRepository.deleteById(authorId);
        }

    public BookPersistent updateBook(BookPersistent book) {
        bookRepository.save(book);
        return book;
    }

}
