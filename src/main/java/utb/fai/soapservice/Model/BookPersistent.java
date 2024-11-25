package utb.fai.soapservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * Entita knihy, ktera je ukladana do databaze
 */
public class BookPersistent {

    private Long id;

    private String title;

    private AuthorPersistent author;

}
