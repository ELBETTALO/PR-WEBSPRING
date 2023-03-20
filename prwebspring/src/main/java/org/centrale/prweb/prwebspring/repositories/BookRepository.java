/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.prweb.prwebspring.repositories;
import org.centrale.prweb.prwebspring.items.*;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>, BookRepositoryCustom {

    public Collection<Book> findByBookId(@Param("bookId")Integer bookId);

    public Collection<Book> findByBookTitle(@Param("bookTitle")String bookTitle);

    public Collection<Book> findByBookAuthors(@Param("bookAuthors")String bookAuthors);

}
