/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.prweb.prwebspring.repositories;

import java.util.Optional;
import org.centrale.prweb.prwebspring.items.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

/**
 *
 * @author ebous
 */
public class BookRepositoryCustomImpl implements BookRepositoryCustom {
    
    @Autowired
    @Lazy
    private BookRepository repository;

    @Override
    public Book update(int id, String title, String authors) {
        if (id > 0) {
            Book item = repository.getReferenceById(id);
            item.setBookTitle(title);
            item.setBookAuthors(authors);
            repository.save(item);

            return item;
        }

        return null;
    }

    @Override
    public Book create(String title, String authors) {
        Book item = new Book();
        item.setBookTitle(title);
        item.setBookAuthors(authors);
        repository.save(item);

        Optional<Book> result = repository.findById(item.getBookId());
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public void remove(int id) {
        if (id > 0) {
            Book item = repository.getReferenceById(id);
            repository.delete(item);
        }
    }
    
}
