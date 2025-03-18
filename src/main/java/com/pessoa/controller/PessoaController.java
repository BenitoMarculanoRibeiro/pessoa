package com.pessoa.controller;

import com.pessoa.model.Pessoa;
import com.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = "*")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private PessoaService service;

	@GetMapping
	public List<Pessoa> listarTodas() {
		return service.listarTodas();
	}

	@GetMapping("/{id}")
	public Optional<Pessoa> buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

	@PostMapping
	public Pessoa salvar(@RequestBody Pessoa pessoa) {
		return service.salvar(pessoa);
	}

	@PutMapping("/{id}")
	public Pessoa atualizar(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		pessoa.setId(id);
		return service.atualizar(pessoa);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}

	@GetMapping("/{id}/peso-ideal")
	public ResponseEntity<Double> calcularPesoIdeal(@PathVariable Long id) {
		double pesoIdeal = pessoaService.calcularPesoIdeal(id);
		return ResponseEntity.ok(pesoIdeal);
	}
}
