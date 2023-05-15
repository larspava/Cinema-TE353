import java.time.LocalDateTime;
import java.util.Collections;

public class Sessao implements Comparable<Sessao>{
	private Filme filme;
	private Local local;
	private float preco;
	private LocalDateTime data;

	// opcional
	private String comentario;
	// ter um atributo comentário no filme OU Sessão
	// se feito nos dois, é bônus
	
	// PRECISA guardar a DATA e HORÁRIO da sessão
	// opcao 1, LocalDateTime 
	// opcao 2, separa em 2, LocalDate, LocalTime


	public Sessao(Filme filme, Local local, float preco, LocalDateTime data, String comentario) {
		this.filme = filme;
		this.local = local;
		this.preco = preco;
		this.data = data;
		this.comentario = comentario;
	}

	public Sessao(Filme filme, Local local, float preco, LocalDateTime data) {
		this.filme = filme;
		this.local = local;
		this.preco = preco;
		this.data = data;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public LocalDateTime getData() { return data; }

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


	public int compareTo(Sessao sessao) {
		return this.filme.getNome().compareToIgnoreCase(sessao.getFilme().getNome());
	}

}
