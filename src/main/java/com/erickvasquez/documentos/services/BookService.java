package com.erickvasquez.documentos.services;

import java.util.List;

import com.erickvasquez.documentos.models.entities.Book;

public interface BookService {
	// find, finOnById, save, delete
	void save(Book book);
	void delete(String isbn);
	Book finfOneById(String isbn);
	List<Book> findAll();
}
