package loja.model;

public abstract class Filme {
	
	private int idFilme;
	private String titulo;
	private String diretor;
	private String genero;
	private int anoLancamento;
	private float preco;
	private int tipo;
	
	public Filme(int idFilme, String titulo, String diretor, String genero, int anoLancamento, float preco, int tipo) {
		this.idFilme = idFilme;
		this.titulo = titulo;
		this.diretor = diretor;
		this.genero = genero;
		this.anoLancamento = anoLancamento;
		this.preco = preco;
		this.tipo = tipo;
	}

	public int getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void visualizar() {
		String tipo = "";
		
		switch(this.tipo) {
		case 1: 
			tipo = "Edição Simples";
			break;
		case 2: 
			tipo = "Edição Especial";
			break;
		}
		
		System.out.println("\n\n============================================================");
		System.out.println("                      Dados do Filme                        ");
		System.out.println("============================================================");
		System.out.println("Título do Filme: " + this.titulo);
		System.out.println("Diretor: " + this.diretor);
		System.out.println("Gênero do Filme: " + this.genero);
		System.out.println("Ano de Lançamento: " + this.anoLancamento);
		System.out.println("Tipo de Edição: " + tipo);
		System.out.printf("Preço: R$ %.2f%n", this.preco);
		System.out.println("Número de Identificação: " + this.idFilme);
	}
}
