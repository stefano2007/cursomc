package com.stefanoferreira.cursomc.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanoferreira.cursomc.Repository.ClienteRepository;
import com.stefanoferreira.cursomc.Service.exceptions.ObjectNotFoundException;
import com.stefanoferreira.cursomc.domain.Cliente;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
