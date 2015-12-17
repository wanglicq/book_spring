package com.thoughtworks.jimmy.controller;

import com.thoughtworks.jimmy.model.Book;
import com.thoughtworks.jimmy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BookShelfController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody Iterable<Book> queryBooks(){
        return bookService.findAll();
    }

    @RequestMapping(value = "book/{isbn}", method = RequestMethod.GET)
    public @ResponseBody Book showBook(@PathVariable String isbn){
        return bookService.findByIsbn(isbn);
    }


    @RequestMapping(value = "book/new", method = RequestMethod.GET)
    public ModelAndView newBook() {

        ModelMap model = new ModelMap();
        model.put("book", new Book());
        return new ModelAndView("newBook", model);

    }

    @RequestMapping(value = "book", method = RequestMethod.POST)
    public @ResponseBody Book saveBook(Book book){

        bookService.create(book);
        return bookService.findByIsbn(book.getIsbn());

    }

    @RequestMapping(value = "book/edit/{isbn}", method = RequestMethod.GET)
    public ModelAndView editBook(@PathVariable String isbn) {

        ModelMap model = new ModelMap();
        model.put("book", bookService.findByIsbn(isbn));
        return new ModelAndView("newBook", model);

    }

    @RequestMapping(value = "book/delete/{isbn}", method = RequestMethod.GET)
    public ModelAndView deleteBook(@PathVariable String isbn) {

        ModelMap model = new ModelMap();
        model.put("book", bookService.findByIsbn(isbn));
        return new ModelAndView("deleteBook", model);

    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String removeBook(Book book) {

        bookService.delete(book.getIsbn());
        return "redirect:/";

    }


}
