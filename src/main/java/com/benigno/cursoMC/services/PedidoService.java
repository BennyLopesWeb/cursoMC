package com.benigno.cursoMC.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benigno.cursoMC.domain.Pedido;
import com.benigno.cursoMC.repositories.PedidoRepository;
import com.benigno.cursoMC.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Optional<Pedido> buscar(Integer id) {
		
		Optional<Pedido> obj = repo.findById(id);
		return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName())));

	}
}
