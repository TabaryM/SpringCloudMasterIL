package fr.masteril.bookservice.modele;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Tabary
 */
@Component
public class InitDB implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InitDB(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) {
        System.out.println("======== Création de la Base de Données ========");
        String[] sqlStatement = {
                "drop table book if exists",
                "create table book(id serial, isbn varchar(20), titre varchar(255), author varchar(255), type varchar(127), price double)",
                "INSERT INTO book(isbn, titre, author, type, price) VALUES('9782379890581', 'La forteresse du chaudron noir', 'Bob Lennon', 'aventure', 12.9) ;",
                "INSERT INTO book(isbn, titre, author, type, price) VALUES('9782352942556', 'Le nom du vent', 'Patrick Rothfuss', 'fantasy', 25) ;",
                "INSERT INTO book(isbn, titre, author, type, price) VALUES('9782352946380', 'La peur du sage premiere partie', 'Patrick Rothfuss', 'fantasy', 20) ;",
                "INSERT INTO book(isbn, titre, author, type, price) VALUES('9782352946588', 'La peur du sage seconde partie', 'Patrick Rothfuss', 'fantasy', 20) ;"
        };

        Arrays.stream(sqlStatement).forEach(sql -> {
            System.out.println(sql);
            jdbcTemplate.execute(sql);
        });

        System.out.println("======== Affichage de toutes les livres ========");
        jdbcTemplate.query("select * from book",
                (rs, rowNum) -> {
                    System.out.println("id:" + rs.getLong("id") +
                            " \tnom auteur:" + rs.getString("author") +
                            " \ttitre:" + rs.getString("titre") +
                            " \tgenre:" + rs.getString("type") +
                            " \tprix:" + rs.getDouble("price")
                    );
                    return null;
                });
    }
}
