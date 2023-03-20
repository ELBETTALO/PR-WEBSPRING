package org.centrale.prweb.prwebspring.repositories;

import org.centrale.prweb.prwebspring.items.*;
import java.util.Optional;
import java.util.Collection;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    @Autowired
    @Lazy
    private PersonRepository repository;

    @Override
    public Person update(int id, Person person) {
        if ((id > 0) && (person != null)) {
             Person item = repository.getReferenceById(id);
             item.setPersonFirstname(person.getPersonFirstname());
             item.setPersonLastname(person.getPersonLastname());
             item.setPersonBirthdate(person.getPersonBirthdate());
             repository.saveAndFlush(person);
             return person;
        }
        return null;

    }

    @Override
    public Person update(int id, String firstName, String lastName, Date birthdate) {
        if (id > 0) {
            Person person = repository.getReferenceById(id);
            person.setPersonFirstname(firstName);
            person.setPersonLastname(lastName);
            if (birthdate != null) {
                person.setPersonBirthdate(birthdate);
            }
            repository.saveAndFlush(person);
            return person;
        }
        return null;
    }

    @Override
    public Person update(Person person, String firstName, String lastName, Date birthdate) {
        if (person != null) {
            person.setPersonFirstname(firstName);
            person.setPersonLastname(lastName);
            if (birthdate != null) {
                person.setPersonBirthdate(birthdate);
            }
            repository.saveAndFlush(person);

            return person;
        }
        return null;
    }

    @Override
    public Person create(String firstName, String lastName, Date birthdate) {
        // Save to database
        Person item = new Person();
        item.setPersonFirstname(firstName);
        item.setPersonLastname(lastName);
        if (birthdate != null) {
            item.setPersonBirthdate(birthdate);
        }
        repository.saveAndFlush(item);

        // Retreive persisted object
        Optional<Person> result = repository.findById(item.getPersonId());
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public void remove(int id) {
        if (id > 0) {
            Person person = repository.getReferenceById(id);
            repository.delete(person);
        }
    }

    @Override
    public void remove(Person item) {
        if (item != null) {
            repository.delete(item);
        }
    }

    @Override
    public Person getByPersonId(Integer personId) {
        Optional<Person> result = repository.findById(personId);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
