package com.erickvasquez.documentos.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jakarta.validation.Valid;

import com.erickvasquez.documentos.models.dtos.BookUserDTO;
import com.erickvasquez.documentos.models.dtos.SearchBookDTO;
import com.erickvasquez.documentos.models.entities.Book;
import com.erickvasquez.documentos.models.entities.User;
import com.erickvasquez.documentos.services.BookService;
import com.erickvasquez.documentos.services.UserService;

@RestController
@RequestMapping("/library")
@CrossOrigin("*")
public class LibraryController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/book")
	public ResponseEntity<?> findOneBookByIsbnAndUser(
			@Valid SearchBookDTO search, BindingResult validations){
		
		if(validations.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		User userFound = userService.findOneById(search.getIdentifier());
		if(userFound == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Book bookFound = bookService.findOneById(search.getIsbn());
		if(bookFound == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		// AQUI SI HAY ALGO
		BookUserDTO response = new BookUserDTO(bookFound, userFound);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
}
