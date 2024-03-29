package com.kennji.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kennji.workshopmongo.domain.User;
import com.kennji.workshopmongo.dto.UserDTO;
import com.kennji.workshopmongo.repository.UserRepository;
import com.kennji.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	//Instanciação do obj automatico do Spring
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateDate(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateDate(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(),objDto.getEmail());
	}
}
