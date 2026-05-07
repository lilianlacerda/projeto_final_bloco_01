package loja.model;

public class EdicaoSimples extends Filme{
	
	private int possuiExtraNoDisco;

	public EdicaoSimples(int idFilme, String titulo, String diretor, String genero, int anoLancamento, float preco,
			int tipo, int possuiExtraNoDisco) {
		
		super(idFilme, titulo, diretor, genero, anoLancamento, preco, tipo);
		this.possuiExtraNoDisco = possuiExtraNoDisco;
	}

	public int isPossuiExtraNoDisco() {
		return possuiExtraNoDisco;
	}

	public void setPossuiExtraNoDisco(int possuiExtraNoDisco) {
		this.possuiExtraNoDisco = possuiExtraNoDisco;
	}
	
	public void visualizar() {
		
		String possuiExtraNoDisco = "";
		
		switch(this.possuiExtraNoDisco) {
		case 1:
			possuiExtraNoDisco = "Sim";
			break;
		case 2:
			possuiExtraNoDisco = "Não";
			break;
		}
		
		super.visualizar();
		System.out.println("Possui extra: " + possuiExtraNoDisco);
	}
}
