import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

// lista agrega todas as sessões
// ela encapsula um arraylist de forma
// a esconder sua estrutura interna 
public class Lista implements Iterable<Sessao>{
	private ArrayList<Sessao> lista;

	// construtor
	public Lista(ArrayList<Sessao> lista) {
		this.lista = lista;
	}

	public void addFilme(Sessao sessao){
		lista.add(sessao);
	}

	// getters e setters
	public ArrayList<Sessao> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Sessao> lista) {
		this.lista = lista;
	}

	// outros para ORDENACAO
	
	
	@Override
	public Iterator<Sessao> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// toString


	@Override
	public String toString() {
		return "Lista{" +
				"lista=" + lista +
				'}';
	}
}
