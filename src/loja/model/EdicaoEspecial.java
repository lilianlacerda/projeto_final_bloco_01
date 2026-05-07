package loja.model;

public class EdicaoEspecial extends Filme{
	
	private int possuiBrindesFisicos;
	
	public EdicaoEspecial(int idFilme, String titulo, String diretor, String genero, int anoLancamento, float preco,
			int tipo, int brindesFisicos) {
		
		super(idFilme, titulo, diretor, genero, anoLancamento, preco, tipo);
		this.possuiBrindesFisicos = brindesFisicos;
	}

	public int getBrindesFisicos() {
		return possuiBrindesFisicos;
	}

	public void setBrindesFisicos(int brindesFisicos) {
		this.possuiBrindesFisicos = brindesFisicos;
	}
	
public void visualizar() {
		
		String possuiBrindesFisicos = "";
		
		switch(this.possuiBrindesFisicos) {
		case 1:
			possuiBrindesFisicos = "Sim";
			break;
		case 2:
			possuiBrindesFisicos = "Não";
			break;
		}
		
		super.visualizar();
		System.out.println("Possui extra: " + possuiBrindesFisicos);
	}
}
