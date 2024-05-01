package com.example.demo.bookController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.bookEntity.Book;
import com.example.demo.bookEntity.MyBookList;
import com.example.demo.bookService.BookService;
import com.example.demo.bookService.MyBookService;


@Controller
public class bookController {
	
	@Autowired
	BookService bkService;
	
	@Autowired
	MyBookService mybService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book> list = bkService.getAllBook();
//		ModelAndView m = new ModelAndView();
//		m.setViewName("BookList");
//		m.addObject("book" , bkList);
//		return m;
		return new ModelAndView("bookList", "book", list);
	}
	
	@PostMapping("/addBook")
	public String addBook(@ModelAttribute Book b) {
		
		bkService.addBook(b);
		return "redirect:/available_books";
	}
	
	@GetMapping("/my_Book")
	public String getMyBook(Model model) {
		List<MyBookList> list = mybService.getAllMyBook();
		model.addAttribute("book" , list);
		return "myBook";
	}
	
	@RequestMapping("/myBook/{id}")
	public String addMyBook(@PathVariable("id") int id) {
		Book b = bkService.getBookById(id);
		MyBookList myb = new MyBookList(b.getId() , b.getName() , b.getAuthor() , b.getPrice());
		mybService.addMyBook(myb);
		return "/redirect:/myBook";
	}
	
	
	
		
}
