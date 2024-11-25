package utb.fai.soapservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entita autora, ktera je ukladana do databaze
 */
public class AuthorPersistent {

    private Long id;

    private String name;

    private String surname;

}
