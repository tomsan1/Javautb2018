package test.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import test.Book;

import test.database.DataDAO;
import test.database.IDataDAO;


@Controller
public class MainController {

    @Autowired
    private IDataDAO dataDao;
   
    @GetMapping("/books")
    public String books(Map<String, Object> model, String query1) {
    	
    	List<Book> theBooks = dataDao.fetchBooks();
    	
    	model.put("books", theBooks);
    	    	
        return "books";
    }
    
    @GetMapping("/index")
    public String index(Map<String, Object> model, String query1) {
    	
    	
        return "index";
    }
    
    @GetMapping("/addbooks")
    public String addbooks(Map<String, Object> model, String query1) {
        return "addbooks";
    }
    
    @GetMapping("/editbook")
    public String editbook(Map<String, Object> model, String query1) {
        return "editbook";
    }
  
    @GetMapping("/searchbook")
    public String searchbook(Map<String, Object> model, String query1) {
        return "searchbook";
    }
    
    @GetMapping("/deletebook")
    public String deletebook(Map<String, Object> model, String query1) {
        return "deletebook";
    }
    
    @GetMapping("/savebook")
    public String savebook(@RequestParam("title") String title, @RequestParam("description") String description) {
    	
    	//do stuff to save book
    	Book aBook = new Book();
    	aBook.setTitle(title);
    	aBook.setDescription(description);
    	
    	dataDao.saveBook(aBook);
        return "savebook";
    }

}