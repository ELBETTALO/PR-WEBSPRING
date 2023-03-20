
package org.centrale.prweb.prwebspring.repositories;
import org.centrale.prweb.prwebspring.items.*;
import java.util.Optional;
import java.util.Calendar;
import java.util.Date;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class BorrowRepositoryCustomImpl implements BorrowRepositoryCustom {

    @Autowired
    @Lazy
    private BorrowRepository repository;

    @Override
    public Borrow create(Person person, Book book, Date borrowDate) {
        if ((borrowDate != null)) {
            Borrow item = new Borrow();
            item.setBorrowDate(borrowDate);
            item.setPersonId(person);
            item.setBorrowDate(borrowDate);
            item.setBookId(book);
            repository.saveAndFlush(item);

            Optional<Borrow> result = repository.findById(item.getBorrowId());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }

    @Override
    public Borrow create(Person person, Book book) {
        Calendar aCalendar = Calendar.getInstance();
        Date borrowDate = aCalendar.getTime();
        return create(person, book, borrowDate);
    }

    @Override
    public void remove(Borrow item) {
        if (item != null) {
          repository.delete(item);
        }
    }

    @Override
    public Borrow getByBorrowId(Integer borrowId) {
        Optional<Borrow> result = repository.findById(borrowId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public Borrow returnBook(Borrow item, Date date) {
        if ((item != null) && (date != null)) {
            item.setBorrowReturn(date);
            repository.saveAndFlush(item);
            return item;
        }
        return null;
    }

    @Override
    public Borrow returnBook(Borrow item) {
        Calendar aCalendar = Calendar.getInstance();
        Date date = aCalendar.getTime();
        return returnBook(item, date);
    }

    @Override
    public Borrow returnBook(int borrowId) {
        if (borrowId > 0) {
            Borrow item = repository.getReferenceById(borrowId);
            if (item != null) {
                return returnBook(item);
            }
        }
        return null;
    }
}
