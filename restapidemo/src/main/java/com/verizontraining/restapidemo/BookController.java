package com.verizontraining.restapidemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	List<Book> books = new ArrayList<Book>();
	//@RequestMapping(value = "/books", method = RequestMethod.GET)
	@GetMapping("/books")
	public List<Book> getBooks() {
		return books;
	}
	
	@PostMapping("/book")
	public Book createBook(@RequestBody Book book) {
		books.add(book);
		return book;
	}
	
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") String id) {
		System.out.println(id);
		Book bk = null;
		for(Book book : books) {
			System.out.println(book.getId());
			if(book.getId().equals(id)) {
				System.out.println("------------");
				bk=book;
				break;
			}
		}
		return bk;
	}
	
	@PutMapping("/book/{id}")
	public Book updateBook(@PathVariable("id") String id, @RequestBody Book bookReq) {
		System.out.println(id);
		for(Book book : books) {
			System.out.println(book.getId());
			if(book.getId().equals(id)) {
				book.setId(bookReq.getId());
				book.setName(bookReq.getName());
				book.setAuthor(bookReq.getAuthor());
				break;
			}
		}
		return bookReq;
	}
	
	@DeleteMapping("/book/{id}")
	public void deleteBook(@PathVariable("id") String id) {
		System.out.println(id);
		for(Book book : books) {
			System.out.println(book.getId());
			if(book.getId().equals(id)) {
				books.remove(book);
				break;
			}
		}
	}
	
}
