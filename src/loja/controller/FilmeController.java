package loja.controller;

import java.util.ArrayList;
import java.util.List;

import loja.model.Filme;
import loja.repository.IFilmeRepository;

public class FilmeController implements IFilmeRepository {

	private List<Filme> listaFilmes = new ArrayList<Filme>();
	int idUltimoFilme;

	@Override
	public void cadastrar(Filme filme) {
		listaFilmes.add(filme);
		System.out.println("O Filme " + filme.getTitulo() + " foi criado com sucesso!\n");

	}

	@Override
	public void listarTodos() {
		for (var filme : listaFilmes) {
			filme.visualizar();
		}
	}

	@Override
	public void atualizar(Filme filme) {
		var buscaFilme = buscarNaCollection(filme.getIdFilme());

		if (buscaFilme != null) {
			listaFilmes.set(listaFilmes.indexOf(buscaFilme), filme);
			System.out.println("\nO Filme numero: " + filme.getIdFilme() + " foi atualizado com sucesso!");
		} else
			System.out.println("\nO Filme numero: " + filme.getIdFilme() + " não foi encontrado!");

	}

	@Override
	public void deletar(int idFilme) {
		var filme = buscarNaCollection(idFilme);
		
		if(filme != null) {
			if(listaFilmes.remove(filme) == true) {
				System.out.println("\nO Filme numero: " + filme.getIdFilme() + " foi atualizado com sucesso!");
			}
		}else {
			System.out.printf("O Filme numero: %d não foi encontrado!%n", idFilme);
		}
	}
	
	@Override
	public void buscarPorId(int idFilme) {
		var filme = buscarNaCollection(idFilme);
		
		if(filme != null) {
			filme.visualizar();
		}else {
			System.out.println("O filme com número identificador: " + idFilme + "não foi encontrado!");
		}
	}
	
	@Override
	public void buscarPorNome(String nome) {
		List<Filme> filmesEncontrados = buscarNome(nome);
		
		if(filmesEncontrados.isEmpty()) {
			System.out.println("\nO filme " + nome + " não foi encontrado!");
			
		}else {
			for(Filme filme : filmesEncontrados) {
				filme.visualizar();
			}
		}
	}

	public int gerarId() {
		return ++idUltimoFilme;
	}

	public Filme buscarNaCollection(int idFilme) {
		for (var filme : listaFilmes) {
			if (filme.getIdFilme() == idFilme) {
				return filme;
			}
		}

		return null;
	}
	
	public List<Filme> buscarNome(String nome){
			List<Filme> nomesFilmes = listaFilmes.stream()
					.filter(filme -> filme.getTitulo()
							.toLowerCase()
							.contains(nome.toLowerCase()))
					.toList();
			
			return nomesFilmes;
	}
}
