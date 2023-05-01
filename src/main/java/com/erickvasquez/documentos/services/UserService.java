package com.erickvasquez.documentos.services;

import com.erickvasquez.documentos.models.dtos.RegisterDTO;
import com.erickvasquez.documentos.models.entities.User;

public interface UserService {
	//  register, findOneById
	
	void register(RegisterDTO info);
	User findOneById(String id);
}
