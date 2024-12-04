package utb.fai.soapservice.Model;

import com.example.book_web_service.Book;
import jakarta.persistence.*;


/**
 * Entita knihy, ktera je ukladana do databaze
 */
@Entity
public class BookPersistent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    private AuthorPersistent author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AuthorPersistent getAuthor() {
        return author;
    }

    public void setAuthor(AuthorPersistent author) {
        this.author = author;
    }


}