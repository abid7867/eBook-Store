package com.example.demo.bookRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.bookEntity.MyBookList;

@Repository
public interface MyBookRepository extends JpaRepository<MyBookList, Integer>{

}
