
package org.centrale.prweb.prwebspring.repositories;
import org.centrale.prweb.prwebspring.items.*;
import java.util.Collection;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>, PersonRepositoryCustom {

    public Collection<Person> findByPersonId(@Param("personId")Integer personId);

    public Collection<Person> findByPersonFirstname(@Param("personFirstname")String personFirstname);

    public Collection<Person> findByPersonLastname(@Param("personLastname")String personLastname);

    public Collection<Person> findByPersonBirthdate(@Param("personBirthdate")Date personBirthdate);

}
