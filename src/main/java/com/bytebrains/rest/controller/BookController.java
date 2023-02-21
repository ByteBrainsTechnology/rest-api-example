package com.bytebrains.rest.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bytebrains.rest.model.Book;

@RestController
@RequestMapping("/books")
public class BookController {

	private static final List<Book> books = new ArrayList<>(Arrays.asList(
			new Book(1L, "The Great Gatsby", "F. Scott Fitzgerald", "1925-04-10"),
			new Book(2L, "To Kill a Mockingbird", "Harper Lee", "1960-07-11"),
			new Book(3L, "1984", "GeorgeOrwell", "1949-06-08"), new Book(5L, "1984", "GeorgeOrwell", "1949-06-08"),
			new Book(4L, "1984", "GeorgeOrwell", "1950-06-08")));

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, })
	public List<Book> getBookByFilter(@RequestParam String title, @RequestParam String author) {
		return books.stream().filter(book -> book.getTitle().equals(title) && book.getAuthor().equals(author)).toList();
	}

	@GetMapping(value = "/{bookId}", produces = MediaType.APPLICATION_XML_VALUE)
	public Book getBookById(@PathVariable Long bookId) {
		return books.stream().filter(book -> book.getId().equals(bookId)).findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
	}
}