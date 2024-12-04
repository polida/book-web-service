package utb.fai.soapservice;

import com.example.book_web_service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

// nutne nejdrive nadefinovat CreateBookRequest a Reponse v books.xsd aby se tridy vygenerovali a import byl funkci

import utb.fai.soapservice.Model.AuthorPersistent;
import utb.fai.soapservice.Model.BookPersistent;

import com.example.book_web_service.DeleteBookRequest;
import com.example.book_web_service.DeleteBookResponse;



@Endpoint
public class LibraryEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/book-web-service";

    @Autowired
    private LibraryService libraryService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookRequest")
    @ResponsePayload
    public GetBookResponse getBook(@RequestPayload GetBookRequest request) {
        GetBookResponse response = new GetBookResponse();
        response.setBook(convertToBook(libraryService.getBook(request.getBookId())));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createBookRequest")
    @ResponsePayload
    public CreateBookResponse createBook(@RequestPayload CreateBookRequest request) {
        var book = request.getBook();
        if(!ValidateBook(book)){
            throw new IllegalArgumentException("Book is not valid");
        }
        CreateBookResponse response = new CreateBookResponse();
        response.setBook(convertToBook(libraryService.createBook(convertToBookPersistent(book))));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteBookRequest")
    @ResponsePayload
    public DeleteBookResponse deleteBook(@RequestPayload DeleteBookRequest request) {
        libraryService.deleteBook(request.getBookId());
        DeleteBookResponse response = new DeleteBookResponse();
        response.setMessage("Books deleted successfully");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateBookRequest")
    @ResponsePayload
    public UpdateBookResponse updateBook(@RequestPayload UpdateBookRequest request) {
        var book = request.getBook();
        if(!ValidateBook(book)){
            throw new IllegalArgumentException("Book is not valid");
        }
        UpdateBookResponse response = new UpdateBookResponse();
        response.setBook(convertToBook(libraryService.updateBook(convertToBookPersistent(book))));

        return  response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAuthorRequest")
    @ResponsePayload
    public GetAuthorResponse getAuthor(@RequestPayload GetAuthorRequest request) {
        GetAuthorResponse response = new GetAuthorResponse();
        response.setAuthor(convertToAuthor(libraryService.getAuthor(request.getAuthorId())));
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createAuthorRequest")
    @ResponsePayload
    public CreateAuthorResponse createAuthor(@RequestPayload CreateAuthorRequest request) {
        var author = request.getAuthor();
        if(!ValidateAuthor(author)){
            throw new IllegalArgumentException("Author is not valid");
        }
        CreateAuthorResponse response = new CreateAuthorResponse();
        response.setAuthor(convertToAuthor(libraryService.createAuthor(convertToAuthorPersistent(author))));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteAuthorRequest")
    @ResponsePayload
    public DeleteAuthorResponse deleteAuthor(@RequestPayload DeleteAuthorRequest request) {
        libraryService.deleteAuthor(request.getAuthorId());
        DeleteAuthorResponse response = new DeleteAuthorResponse();
        response.setMessage("Author deleted successfully");
        return response;
    }

    private Book convertToBook(BookPersistent bookPersistent) {
        Book book = new Book();
        book.setId(bookPersistent.getId());
        book.setTitle(bookPersistent.getTitle());
        book.setAuthorID(bookPersistent.getAuthor().getId());
        return book;
    }

    private BookPersistent convertToBookPersistent(Book book) {
        BookPersistent bookPersistent = new BookPersistent();
        bookPersistent.setId(book.getId());
        bookPersistent.setTitle(book.getTitle());
        AuthorPersistent author = new AuthorPersistent();
        author.setId(book.getAuthorID());
        bookPersistent.setAuthor(author);
        return bookPersistent;
    }

    private Author convertToAuthor(AuthorPersistent authorPersistent) {
        Author author = new Author();
        author.setId(authorPersistent.getId());
        author.setName(authorPersistent.getName());
        author.setSurname(authorPersistent.getSurname());
        return author;
    }

    private AuthorPersistent convertToAuthorPersistent(Author author) {
        AuthorPersistent authorPersistent = new AuthorPersistent();
        authorPersistent.setId(author.getId());
        authorPersistent.setName(author.getName());
        authorPersistent.setSurname(author.getSurname());
        return authorPersistent;
    }
    private boolean ValidateBook(Book book){
        return !book.getTitle().isEmpty() && book.getAuthorID() >= 0 && book.getId() >= 0;
    }
    public boolean ValidateAuthor(Author author){
        return author.getName().matches("[a-zA-Z]+") && author.getSurname().matches("[a-zA-Z]+") && author.getId() >= 0;
    }
}