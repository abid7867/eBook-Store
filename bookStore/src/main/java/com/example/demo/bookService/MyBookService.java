package com.example.demo.bookService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.bookEntity.MyBookList;
import com.example.demo.bookRepository.MyBookRepository;

@Service
public class MyBookService {
	
	@Autowired
	MyBookRepository myBookRepo;

	public MyBookService(MyBookRepository myBookRepo) {
		super();
		this.myBookRepo = myBookRepo;
	}
	
	public void addMyBook(MyBookList myB)
	{
		myBookRepo.save(myB);
		
	}
	
	public List<MyBookList> getAllMyBook()
	{
		return myBookRepo.findAll();
	}
	
	public void deleteMyBook(int id)
	{
		myBookRepo.deleteById(id);
	}
//	public String updateMyBook(MyBook myB)
//	{
//		myBookRepo.save(myB);
//		return "My Book is Added..";
//	}
	

}
