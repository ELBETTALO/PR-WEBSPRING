
package org.centrale.prweb.prwebspring.repositories;
import org.centrale.prweb.prwebspring.items.*;
import java.util.Collection;
import java.util.Date;

public interface PersonRepositoryCustom {
    /**
     * Create new person
     * @param firstName
     * @param lastName
     * @param birthdate 
     * @return  
     */
    public Person create(String firstName, String lastName, Date birthdate);

    /**
     * Update user
     * @param id
     * @param firstName
     * @param lastName
     * @param birthdate
     * @return 
     */
    public Person update(int id, String firstName, String lastName, Date birthdate);
    
    
    
    public Person update(int id, Person person);

    /**
     * Update user
     * @param person
     * @param firstName
     * @param lastName
     * @param birthdate
     * @return 
     */
    public Person update(Person person, String firstName, String lastName, Date birthdate);
    
    /**
     * Remove Person
     * @param itemId
     */
    public void remove(int itemId);
    
    /**
     * Remove Person
     * @param item
     */
    public void remove(Person item);

    /**
     * Get a Person from its ID
     * @param personId
     * @return Person
     */
    public Person getByPersonId(Integer personId);

}
