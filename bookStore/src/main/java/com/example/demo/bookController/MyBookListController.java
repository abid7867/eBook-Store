package com.example.demo.bookController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.bookService.MyBookService;

@Controller
public class MyBookListController {
	
	@Autowired
	MyBookService myBookService;
	
	@RequestMapping("deleteMyBook/{id}")
	public String deleteMyBook(@PathVariable("id") int id)
	{
		myBookService.deleteMyBook(id);
		return "/redirect:/my_Book";
	}
}
