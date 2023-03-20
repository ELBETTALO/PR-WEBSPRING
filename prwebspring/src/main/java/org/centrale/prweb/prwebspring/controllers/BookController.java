/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.prweb.prwebspring.controllers;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.centrale.prweb.prwebspring.items.Book;
import org.centrale.prweb.prwebspring.items.Person;
import org.centrale.prweb.prwebspring.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ebous
 */
@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    private int getIntFromString(String value) {
        int intValue = -1;
        try {
            intValue = Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.WARNING, null, ex);

        }
        return intValue;

    }

    @RequestMapping(value = "editbook.do", method = RequestMethod.POST)
    public ModelAndView handleEditUserPost(HttpServletRequest request) {
        ModelAndView returned;

        String idStr = request.getParameter("id");
        int id = getIntFromString(idStr);

        if (id > 0) {
            // Id may exist
            Book Book = bookRepository.getReferenceById(id);
            returned = new ModelAndView("book");
            returned.addObject("book", Book);
        } else {
            returned = new ModelAndView("books");
            Collection<Book> myList = bookRepository.findAll();
            returned.addObject("booksList", myList);
        }
        return returned;
    }

    @RequestMapping(value = "savebook.do", method = RequestMethod.POST)
    public ModelAndView handlePostSaveBook(HttpServletRequest request) {
        ModelAndView returned;

        // Create or update book
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String idStr = request.getParameter("id");
        int id = getIntFromString(idStr);
        String title = request.getParameter("title");
        String authors = request.getParameter("authors");
        if (id > 0) {
            bookRepository.update(id, title, authors);
        } else {
            bookRepository.create(title, authors);
        }

        // return view
        returned = new ModelAndView("books");
        Collection<Book> myList = bookRepository.findAll();
        returned.addObject("booksList", myList);

        return returned;
    }

     @RequestMapping(value = "deletebook.do", method = RequestMethod.POST)
    public ModelAndView handlePostDeletebook(HttpServletRequest request) {
        ModelAndView returned;

        String idStr = request.getParameter("id");
        int id = getIntFromString(idStr);
        bookRepository.remove(id);

        returned = new ModelAndView("books");
        Collection<Book> myList = bookRepository.findAll();
        returned.addObject("booksList", myList);

        return returned;
    }

    @RequestMapping(value = "createbook.do", method = RequestMethod.POST)
    public ModelAndView handlePostCreatebook() {
        ModelAndView returned;

        Book newBook = new Book();
        returned = new ModelAndView("book");
        returned.addObject("book", newBook);

        return returned;
    }

    
    
    
    @RequestMapping(value = "books.do")
    public ModelAndView handleLBooksPost(HttpServletRequest request) {
        ModelAndView returned;

        returned = new ModelAndView("books");
        Collection<Book> myList = bookRepository.findAll();
        returned.addObject("booksList", myList);

        return returned;
    }

}
