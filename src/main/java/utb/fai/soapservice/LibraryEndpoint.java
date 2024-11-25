package utb.fai.soapservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.book_web_service.Author;
import com.example.book_web_service.Book;
import com.example.book_web_service.GetBookRequest;
import com.example.book_web_service.GetBookResponse;
import com.example.book_web_service.CreateBookRequest;
import com.example.book_web_service.CreateBookResponse;
import com.example.book_web_service.UpdateBookRequest;
import com.example.book_web_service.UpdateBookResponse;

import utb.fai.soapservice.Model.AuthorPersistent;
import utb.fai.soapservice.Model.BookPersistent;

import com.example.book_web_service.DeleteBookRequest;
import com.example.book_web_service.DeleteBookResponse;
import com.example.book_web_service.GetAuthorRequest;
import com.example.book_web_service.GetAuthorResponse;
import com.example.book_web_service.CreateAuthorRequest;
import com.example.book_web_service.CreateAuthorResponse;
import com.example.book_web_service.DeleteAuthorRequest;
import com.example.book_web_service.DeleteAuthorResponse;

@Endpoint
public class LibraryEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/book-web-service";

    @Autowired
    private LibraryService libraryService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookRequest")
    @ResponsePayload
    public GetBookResponse getBook(@RequestPayload GetBookRequest request) {
        // TODO: implement getBook
        return null;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createBookRequest")
    @ResponsePayload
    public CreateBookResponse createBook(@RequestPayload CreateBookRequest request) {
        // TODO: implement createBook
        return null;
    }

    // TODO: define this requests updateBookRequest, deleteBookRequest, getAuthorRequest, createAuthorRequest, deleteAuthorRequest

}
