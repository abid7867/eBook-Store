package com.example.demo.bookService;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.bookEntity.Book;
import com.example.demo.bookRepository.BookRepository;

@Service
public class BookService  {
	
	
	BookRepository bkRepo;
	
	
	public BookService(BookRepository bkRepo) {
		super();
		this.bkRepo = bkRepo;
	}

	public String addBook(Book b) {
		bkRepo.save(b);
		return "Book is Added...";
	}

	public List<Book> getAllBook() {
		List<Book> bkList =bkRepo.findAll();
		return bkList;
	}

	public Book getBookById(int id) {
		return bkRepo.findById(id).get();
	
	}
	
	

//	@Override
//	public String updateBook(Book b) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public String deleteBook(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
