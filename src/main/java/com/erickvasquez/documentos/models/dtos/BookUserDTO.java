package com.erickvasquez.documentos.models.dtos;

import com.erickvasquez.documentos.models.entities.Book;
import com.erickvasquez.documentos.models.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class BookUserDTO {
		private Book book;
		private User user;
}
