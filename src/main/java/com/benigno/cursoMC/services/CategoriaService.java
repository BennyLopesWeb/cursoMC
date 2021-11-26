package com.benigno.cursoMC.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benigno.cursoMC.domain.Categoria;
import com.benigno.cursoMC.repositories.CategoriaRepository;
import com.benigno.cursoMC.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Optional<Categoria> buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encotrado! Id:  " +  id
					+ ", Tipo:  "  +  Categoria.class.getName());
		}
		return obj;

	}
}
