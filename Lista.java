import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	
	public void listaAZ(){
		Collections.sort(lista);
	}

	public void ordernaAvaliacao() {
		Collections.sort(lista, new Comparator<Sessao>() {
			@Override
			public int compare(Sessao ses1, Sessao ses2) {
				int nota1 = ses1.getFilme().getNota();
				int nota2 = ses2.getFilme().getNota();

				if (nota1 > nota2) {
					return -1;
				} else if (nota1 > nota2) {
					return 1;
				} else {
					return 0;
				}
			}
		});
	}

	public void ordenaCronologicamente(){
		Collections.sort(lista, new Comparator<Sessao>() {
			@Override
			public int compare(Sessao sessao1, Sessao sessao2) {
				return sessao1.getData().compareTo(sessao2.getData());
			}
		});
	}

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
