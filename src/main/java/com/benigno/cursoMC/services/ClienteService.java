package com.benigno.cursoMC.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benigno.cursoMC.domain.Cliente;
import com.benigno.cursoMC.repositories.ClienteRepository;
import com.benigno.cursoMC.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Optional<Cliente> buscar(Integer id) {
		
		Optional<Cliente> obj = repo.findById(id);
		return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())));

	}
}
