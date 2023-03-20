/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.prweb.prwebspring.repositories;

import org.centrale.prweb.prwebspring.items.Book;

/**
 *
 * @author ebous
 */
public interface BookRepositoryCustom {
    
    
    /**
     * Create new book
     * @param title
     * @param authors
     * @return  
     */
    public Book create(String title, String authors);

    /**
     * Update book
     * @param id
     * @param title
     * @param authors
     * @return 
     */
    public Book update(int id, String title, String authors);
    
    /**
     * Delete book
     * @param id 
     */
    public void remove(int id);

}
    

