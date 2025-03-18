package com.pessoa.service;

import com.pessoa.model.Pessoa;
import com.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public List<Pessoa> listarTodas() {
		return repository.findAll();
	}

	public Optional<Pessoa> buscarPorId(Long id) {
		return repository.findById(id);
	}

	public Pessoa salvar(Pessoa pessoa) {
		return repository.save(pessoa);
	}

	public Pessoa atualizar(Pessoa pessoa) {
		return repository.save(pessoa);
	}

	public void deletar(Long id) {
		repository.deleteById(id);
	}

	public double calcularPesoIdeal(Long id) {
		Pessoa pessoa = repository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
		return pessoa.calcularPesoIdeal();
	}
}
