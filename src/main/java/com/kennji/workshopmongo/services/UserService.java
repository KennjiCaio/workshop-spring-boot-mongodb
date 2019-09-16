package com.kennji.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kennji.workshopmongo.domain.User;
import com.kennji.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	//Instanciação do obj automatico do Spring
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
