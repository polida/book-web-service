package utb.fai.soapservice;

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
        return null;
    }

    public BookPersistent getBook(long bookId) {
        return null;
    }

    public BookPersistent createBook(BookPersistent book) {
        return null;
    }

    public void deleteBook(long bookId) {
        
    }

    public AuthorPersistent createAuthor(AuthorPersistent author) {
        return null;
    }

    public void deleteAuthor(long authorId) {   
    }

}
