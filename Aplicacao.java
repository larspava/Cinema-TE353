import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacao {
	
	// usar a lista de sessões
	private static Lista lista = new Lista(new ArrayList<>()); // IDEM a turma do Projeto Usuario8
	// para simular o banco de dados dos locais
	private static ArrayList<Local> locais = new ArrayList<>(); // IDEM turma, main7, Projeto Usuario6
	// scanner
	private static Scanner teclado = new Scanner(System.in);
	// etc..
	
	public static void main(String[] args) {
		//Variáveis locais
		int opcao;

		//Cinemas de Curitiba
		locais.add(new Local("Shopping Mueller", "Cinemark"));
		locais.add(new Local("Shopping Estação", "UCI"));
		locais.add(new Local("Jockey Plaza Shopping", "UCI"));
		locais.add(new Local("Shopping Jardim das Américas", "Cineplus"));
		locais.add(new Local("Shopping Curitiba", "Cinesystem"));
		locais.add(new Local("Shopping Pátio Batel", "Cinépolis"));
		locais.add(new Local("Shopping Palladium", "UCI"));
		locais.add(new Local("Park Shopping Barigui", "Cinemark"));

		//Filmes
		Filme filme1 = new Filme("Guardiões da Galáxia Vol.3", 4, true, "Todo mundo chorou no cinema quando Peter Quill morreu.");
		Filme filme2 = new Filme("Avatar", 2, false);
		Filme filme3 = new Filme("Her", 5, true, "Profundo, delicado e com boa fotografia");
		Filme filme4 = new Filme("The Flash", 3, false);
		Filme filme5 = new Filme("Toy Story 3", 5, true, "Sessão tranquila, com poucas pessoas.");
		Filme filme6 = new Filme("Star Wars: Rogue One", 4, true, "Sessão cheia, todo mundo gritava no fim, não recomendo o cinema.");
		Filme filme7 = new Filme("Avatar 2", 1, false);
		Filme filme8 = new Filme("Vingadores: Guerra Infinita", 4, false);
		Filme filme9 = new Filme("Pantera Negra", 4, true);
		Filme filme10 = new Filme("Hereditário", 5, true);

		//Sessões
		lista.addFilme(new Sessao(filme1, locais.get(0), 45, LocalDateTime.of(2023,5,10,20,0), "Sessão legal"));
		lista.addFilme(new Sessao(filme2, locais.get(1), 40, LocalDateTime.of(2009,12,29,15,30)));
		lista.addFilme(new Sessao(filme3, locais.get(2), 50, LocalDateTime.of(2013,6,26,13,15), "Sessão vazia"));
		lista.addFilme(new Sessao(filme4, locais.get(3), 34, LocalDateTime.of(2023,5,11,18,0)));
		lista.addFilme(new Sessao(filme5, locais.get(4), 32, LocalDateTime.of(2010,7,12,14,0)));
		lista.addFilme(new Sessao(filme6, locais.get(5), 60, LocalDateTime.of(2016,11,20,21,45), "Tela pequena"));
		lista.addFilme(new Sessao(filme7, locais.get(6), 50, LocalDateTime.of(2023,1,10,20,45)));
		lista.addFilme(new Sessao(filme8, locais.get(7), 48, LocalDateTime.of(2018,2,5,19,0), "Som com problemas"));
		lista.addFilme(new Sessao(filme9, locais.get(0), 45, LocalDateTime.of(2018,4,3,17,15)));
		lista.addFilme(new Sessao(filme10, locais.get(1), 40, LocalDateTime.of(2018,8,5,16,30)));

		// apresentar o menu principal
		do {
			System.out.println("\n   -- MENU --\n");
			System.out.println("0 - sair");
			System.out.println("1 - cadastrar filme");
			System.out.println("2 - Mostrar dados filme (filme, sessão)");
			System.out.println("3 - Editar filme");
			System.out.println("4 - Listagem ordem alfabética");
			System.out.println("5 - Listagem ordem avaliação");
			System.out.println("6 - Listagem cronológica");
			System.out.println("7 - Listagem favoritos");

			System.out.print("\n   Qual sua opcao? ");
			opcao = teclado.nextInt(); // ler um inteiro do teclado
			teclado.nextLine(); // somente para consumir o Enter
			switch (opcao) {
				case 1: {
					lista.addFilme(criarSessao());
					break;
				}
				case 2: {
					Sessao sessao_encontrada = procurarFilme();
					if(sessao_encontrada != null){
						System.out.println("Nome: " + sessao_encontrada.getFilme().getNome());
						System.out.println("Nota: " + sessao_encontrada.getFilme().getNota());
						System.out.println("Favorito: " + sessao_encontrada.getFilme().isFavorito());
						System.out.println("Data: " + getStringData(sessao_encontrada.getData()) + " - " +
								sessao_encontrada.getData().getHour() + "h" + sessao_encontrada.getData().getMinute());
						System.out.println("Preço: R$" + sessao_encontrada.getPreco());
						System.out.println("Local: " + sessao_encontrada.getLocal().getNome());
						if(sessao_encontrada.getFilme().getComentario() != null){
							System.out.println("Comentario do Filme: " + sessao_encontrada.getFilme().getComentario());
						}
						if(sessao_encontrada.getComentario() != null){
							System.out.println("Comentario da Sessão: " + sessao_encontrada.getComentario());
						}
					}
					break;
				}
				case 3: {
					int nota;
					String comentario;

					Sessao sessao_editada = procurarFilme();

					if(sessao_editada != null){
						System.out.print("Qual a nova nota para o filme: ");
						nota = teclado.nextInt();
						teclado.nextLine();
						System.out.print("Qual o novo comentário para o filme: ");
						comentario = teclado.nextLine();

						sessao_editada.getFilme().setNota(nota);
						sessao_editada.getFilme().setComentario(comentario);
					}
					break;
				}
				case 4: {
					lista.listaAZ();
					for(int i= 0; i < lista.getLista().size(); i++){
						System.out.print(lista.getLista().get(i).getFilme().getNome());
						System.out.print(" (" + getStringData(lista.getLista().get(i).getData()) + ") - ");
						System.out.println(lista.getLista().get(i).getLocal().getNome());
					}
					break;
				}
				case 5: {
					lista.ordernaAvaliacao();
					for(int j = 5; j > 0; j--){
						System.out.println("Nota " + j + ":");
						for(int i = 0; i < lista.getLista().size(); i++){
							if(lista.getLista().get(i).getFilme().getNota() == j){
								System.out.print(lista.getLista().get(i).getFilme().getNome());
								System.out.print(" (" + getStringData(lista.getLista().get(i).getData()) + ") - ");
								System.out.println(lista.getLista().get(i).getLocal().getNome());
							}
						}
						System.out.println();
					}
					break;
				}
				case 6: {
					int month = 0;
					int year = 0;
					lista.ordenaCronologicamente();

					for(int i= 0; i < lista.getLista().size(); i++){
						System.out.println();
						Sessao sessao = lista.getLista().get(i);
						int local_month, local_year;
						local_month = sessao.getData().getMonthValue();
						local_year = sessao.getData().getYear();
						if(month != local_month || year != local_year){
							month = local_month;
							year = local_year;
							System.out.println(returnMonth(local_month) + "/" + year);
						}
						System.out.println(sessao.getData().getDayOfMonth() + " (" + returnDay(sessao.getData().getDayOfWeek().getValue())
								+ ", " + sessao.getData().getHour() + ":" + sessao.getData().getMinute() + ") - "
								+ sessao.getFilme().getNome() + " - " + sessao.getLocal().getNome());
					}
					break;
				}
				case 7:
					lista.listaAZ();
					for(int i=0; i < locais.size(); i++){
						Sessao sessao_atual = lista.getLista().get(i);
						if(sessao_atual.getFilme().isFavorito() == "sim"){
							System.out.print(lista.getLista().get(i).getFilme().getNome());
							System.out.print(" (" + getStringData(lista.getLista().get(i).getData()) + ") - ");
							System.out.println(lista.getLista().get(i).getLocal().getNome());
						}
					}
					break;
				}
		} while (opcao != 0);
		teclado.close();

	}

	private static Sessao criarSessao(){
		String data, horario, comentario;
		float preco;
		Local local_escolhido;

		Filme novo_filme = criarFilme();

		/*CRIAÇÃO DA SESSÃO*/
		System.out.println("\n-- Dados da Sessão --\n");
		System.out.print("Escreva a data (formato YYYY-MM-DD): ");
		data = teclado.nextLine();
		System.out.print("Escreva o horário (formato HH:MM): ");
		horario = teclado.nextLine();
		System.out.print("Valor do ingresso: ");
		preco = teclado.nextFloat();
		teclado.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(data + " " + horario, formatter);
		System.out.print("Possui comentários sobre a sessão?('enter' para ignorar): ");
		comentario = teclado.nextLine();

		local_escolhido = retornaLocal();

		if(comentario == null || comentario == ""){
			return new Sessao(novo_filme, local_escolhido, preco, dateTime);
		} else {
			return new Sessao(novo_filme, local_escolhido, preco, dateTime, comentario);
		}
	}

	private static Filme criarFilme() {
		String nome, comentario;
		int nota;
		boolean favorito;
		String resposta;

		/*CRIAÇÃO DO FILME*/
		System.out.println("\n-- Novo Filme --\n");
		System.out.print("Nome do filme: ");
		nome = teclado.nextLine();
		System.out.print("Nota do filme: ");
		nota = teclado.nextInt();
		teclado.nextLine();
		System.out.print("É um dos seus favoritos?(S/N) : ");
		resposta = teclado.nextLine();
		if (resposta.toUpperCase().charAt(0) == 'S') {
			favorito = true;
		} else {
			favorito = false;
		}
		System.out.print("Possui comentários sobre o filme?('enter' para ignorar): ");
		comentario = teclado.nextLine();
		if (comentario == null || comentario == "") {
			return new Filme(nome, nota, favorito);
		} else {
			return new Filme(nome, nota, favorito, comentario);
		}
	}

	private static Local retornaLocal(){
		int numero_local;

		/*ESCOLHA DO LOCAL*/
		for(int i = 0; i < locais.size(); i++){
			System.out.println(i + " - " + locais.get(i));
		}
		System.out.println(locais.size() + " - Novo local");
		numero_local = teclado.nextInt();
		teclado.nextLine();
		if(numero_local == locais.size()){
			System.out.println("Insira o nome do novo local: ");
			String novo_local = teclado.nextLine();
			System.out.println("Insira a franquia do novo local: ");
			String nova_franquia = teclado.nextLine();
			return new Local(novo_local, nova_franquia);
		} else {
			return locais.get(numero_local);
		}
	}

	private static Sessao procurarFilme() {
		String nome;
		String resposta;

		System.out.println("\n-- Procurar Filme --\n");
		System.out.print("Nome do filme a procurar? ");
		nome = teclado.nextLine();
		for (int i = 0; i < lista.getLista().size(); i++) {
			Sessao sessao = lista.getLista().get(i);
			if (sessao.getFilme().getNome().toUpperCase().contains(nome.toUpperCase())) {
				System.out.println("Encontrei <" + sessao.getFilme().getNome() + ">");
				System.out.print("Corresponde a procura, <S/N>? ");
				resposta = teclado.nextLine();
				if (resposta.toUpperCase().charAt(0) == 'S') {
					return sessao;
				}
			}
		}
		System.out.println("Infelizmente <" + nome + "> não encontrado!");
		return null;
	}

	public static String returnMonth(Integer month){
		switch(month){
			case 1:
				return "jan";
			case 2:
				return "fev";
			case 3:
				return "mar";
			case 4:
				return "abr";
			case 5:
				return "mai";
			case 6:
				return "jun";
			case 7:
				return "jul";
			case 8:
				return "ago";
			case 9:
				return "set";
			case 10:
				return "out";
			case 11:
				return "nov";
			case 12:
				return "dez";
			default:
				return "none";
		}
	}

	public static String returnDay(Integer day){
		switch(day) {
			case 1:
				return "seg";
			case 2:
				return "ter";
			case 3:
				return "qua";
			case 4:
				return "qui";
			case 5:
				return "sex";
			case 6:
				return "sab";
			default:
				return "dom";
		}
	}

	public static String getStringData(LocalDateTime data){
		return data.getDayOfMonth() + "/" +  returnMonth(data.getMonthValue()) + "/" + data.getYear() + ", " + returnDay(data.getDayOfWeek().getValue());
	}









}
