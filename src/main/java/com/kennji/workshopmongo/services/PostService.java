package com.kennji.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kennji.workshopmongo.domain.Post;
import com.kennji.workshopmongo.repository.PostRepository;
import com.kennji.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	//Instanciação do obj automatico do Spring
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}
}
