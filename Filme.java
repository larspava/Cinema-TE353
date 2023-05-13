
public class Filme implements Comparable<Filme> {
	private String nome;
	private int nota; // de 0 a 5
	private boolean favorito;
	// opcional
	private String comentario;
	// ter um atributo comentário no filme OU Sessão
	// se feito nos dois, é bônus
	
	// outro adicional 
	//private Genero genero;
	
	// construtor
	public Filme(String nome, int nota, boolean favorito, String comentario) {
		this.nome = nome;
		this.nota = nota;
		this.favorito = favorito;
		this.comentario = comentario;
	}

	public Filme(String nome, int nota, boolean favorito) {
		this.nome = nome;
		this.nota = nota;
		this.favorito = favorito;
	}

	// getters
	public String getNome() {
		return nome;
	}

	public int getNota() {
		return nota;
	}

	public String isFavorito() {
		if(favorito){
			return "sim";
		}
		return "não";
	}

	public String getComentario() {
		return comentario;
	}

	// setters
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


	// toString
	@Override
	public String toString() {
		return "Nome: " + getNome() + '\'' +
				"Nota: " + getNota() + '\'' +
				"Favorito: " + isFavorito();
	}

	@Override
	public int compareTo(Filme filme) {
		// TODO 
		return 0;
	}

}
