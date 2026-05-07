package loja.controller;

import java.util.ArrayList;
import java.util.List;

import loja.model.Filme;
import loja.repository.IFilmeRepository;

public class FilmeController implements IFilmeRepository{
	
	private List<Filme> listaFilmes = new ArrayList<Filme>();
	int idUltimoFilme;

	@Override
	public void cadastrar(Filme filme) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarTodos() {
		for(var filme : listaFilmes) {
			filme.visualizar();
		}
	}

	@Override
	public void atualizar(Filme filme) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int idFilme) {
		// TODO Auto-generated method stub
		
	}

}
