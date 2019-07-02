package com.stefanoferreira.cursomc.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanoferreira.cursomc.Repository.CategoriaRepository;
import com.stefanoferreira.cursomc.Service.exceptions.ObjectNotFoundException;
import com.stefanoferreira.cursomc.domain.Categoria;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
}
