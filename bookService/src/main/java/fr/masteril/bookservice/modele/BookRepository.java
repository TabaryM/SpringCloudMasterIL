package fr.masteril.bookservice.modele;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Tabary
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    @Override
    List<Book> findAll();

    @Override
    Optional<Book> findById(Long aLong);

    Optional<Book> findByIsbn(String isbn);

    @Override
    void deleteById(Long aLong);

    void deleteByIsbn(String isbn);

    void deleteAll();

    Iterable<Book> findAllByAuthor(String author);

    @Override
    boolean existsById(Long aLong);

    boolean existsByIsbn(String isbn);

    @Override
    <S extends Book> S save(S entity);

    @Modifying
    @Query("update Book b set b.price = :newPrice where b.id= :id")
    void changePriceById(@Param("id") Long id, @Param("newPrice") float newPrice);
}
