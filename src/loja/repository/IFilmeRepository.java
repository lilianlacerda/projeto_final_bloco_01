package loja.repository;

import loja.model.Filme;

public interface IFilmeRepository {
	
	public void cadastrar(Filme filme);
	public void listarTodos();
	public void atualizar(Filme filme);
	public void deletar(int idFilme);
	public void buscarPorId(int idFilme);
	public void buscarPorNome(String nome);

}
