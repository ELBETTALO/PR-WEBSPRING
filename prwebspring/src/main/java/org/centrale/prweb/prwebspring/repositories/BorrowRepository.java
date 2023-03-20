
package org.centrale.prweb.prwebspring.repositories;
import org.centrale.prweb.prwebspring.items.*;
import java.util.Collection;
import java.util.Date;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Integer>, BorrowRepositoryCustom {

    public Collection<Borrow> findByBorrowId(@Param("borrowId")Integer borrowId);

    public Collection<Borrow> findByBorrowDate(@Param("borrowDate")Date borrowDate);

    public Collection<Borrow> findByBorrowReturn(@Param("borrowReturn")Date borrowReturn);

}
