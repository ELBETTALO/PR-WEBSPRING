/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.prweb.prwebspring.controllers;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.centrale.prweb.prwebspring.items.Person;
import org.centrale.prweb.prwebspring.repositories.BookRepository;
import org.centrale.prweb.prwebspring.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ebous
 */
@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    @Lazy
    private BookRepository bookRepository;
    private Date getDateFromString(String aDate, String format) {
        Date returnedValue = null;
        try {
            // try to convert
            SimpleDateFormat aFormater = new SimpleDateFormat(format);
            returnedValue = aFormater.parse(aDate);
        } catch (ParseException ex) {
        }

        if (returnedValue != null) {
            Calendar aCalendar = Calendar.getInstance();
            aCalendar.setTime(returnedValue);
        }
        return returnedValue;
    }

    private int getIntFromString(String value) {
        int intValue = -1;
        try {
            intValue = Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.WARNING, null, ex);

        }
        return intValue;

    }

    @RequestMapping(value = "edituser.do", method = RequestMethod.POST)
    public ModelAndView handleEditUserPost(HttpServletRequest request) {
        ModelAndView returned;

        String idStr = request.getParameter("id");
        int id = getIntFromString(idStr);

        if (id > 0) {
            // Id may exist
            Person person = personRepository.getReferenceById(id);
            returned = new ModelAndView("user");
            returned.addObject("user", person);
            returned.addObject("booksList", bookRepository.findAll());

        } else {
            returned = new ModelAndView("users");
            Collection<Person> myList = personRepository.findAll();
            returned.addObject("usersList", myList);
        }
        return returned;
    }

    @RequestMapping(value = "saveuser.do", method = RequestMethod.POST)
    public ModelAndView handlePostSaveUser(HttpServletRequest request) {
        ModelAndView returned;

        // Create or update user
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String idStr = request.getParameter("id");
        int id = getIntFromString(idStr);
        String firstName = request.getParameter("FirstName");
        String lastName = request.getParameter("LastName");
        String birthdateStr = request.getParameter("Birthdate");
        Date birthdate = getDateFromString(birthdateStr, "yyyy-MM-dd");
        if (id > 0) {
            personRepository.update(id, firstName, lastName, birthdate);
        } else {
            personRepository.create(firstName, lastName, birthdate);
        }

        // return view
        returned = new ModelAndView("users");
        Collection<Person> myList = personRepository.findAll();
        returned.addObject("usersList", myList);

        return returned;
    }

    @RequestMapping(value = "deleteuser.do", method = RequestMethod.POST)
    public ModelAndView handlePostDeleteUser(HttpServletRequest request) {
        ModelAndView returned;

        String idStr = request.getParameter("id");
        int id = getIntFromString(idStr);
        personRepository.remove(id);

        returned = new ModelAndView("users");
        Collection<Person> myList = personRepository.findAll();
        returned.addObject("usersList", myList);

        return returned;
    }

    @RequestMapping(value = "createuser.do", method = RequestMethod.POST)
    public ModelAndView handlePostCreateUser() {
        ModelAndView returned;

        Person newPerson = new Person();
        returned = new ModelAndView("user");
        returned.addObject("user", newPerson);

        return returned;
    }
    
    
    @RequestMapping(value = "users.do", method = RequestMethod.POST)
    public ModelAndView handleUsersPost(HttpServletRequest request) {
        ModelAndView returned;

        returned = new ModelAndView("users");
        Collection<Person> myList = personRepository.findAll();
        returned.addObject("usersList", myList);

        return returned;
    }
    

}
