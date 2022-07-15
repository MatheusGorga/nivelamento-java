package br.com.treinaweb.semana2;

import java.util.Scanner;

import br.com.treinaweb.semana2.models.Diarista;
import br.com.treinaweb.semana2.repository.DiaristaRepository;

public class App {
  public static void main(String[] args) {
    var scanner = new Scanner(System.in);
    var repository = new DiaristaRepository();

    var opcao = "q";

    do {
      exibirMenu();

      System.out.print("Informe a opção desejada: ");
      opcao = scanner.nextLine();
      System.out.println();

      switch (opcao) {
        case "1" -> listarDiaristas(repository);
        case "2" -> cadastrarDiarista(scanner, repository);
        case "3" -> buscarDiarista(scanner, repository);
        case "4" -> excluirDiarista(scanner, repository);
        case "q" -> System.out.println("Saindo do sistema");
        default -> System.out.println("opção invalida");

      }

    } while (!opcao.equals("q"));

    scanner.close();

  }

  private static void excluirDiarista(Scanner scanner, DiaristaRepository repository) {
    System.out.print("Informe o Id: ");
    var id = scanner.nextLong();
    scanner.nextLine();

    var foiExcluido = repository.excluirPorId(id);

    if (foiExcluido) {
      System.out.println("Diarista excluido");
    } else {
      System.out.println("Diarista não encontrado");

    }

  }

  private static void buscarDiarista(Scanner scanner, DiaristaRepository repository) {
    System.out.println("==============================================");
    System.out.print("Informe o Id: ");
    var id = scanner.nextLong();
    scanner.nextLine();

    var diarista = repository.buscarPorId(id);
    if (diarista != null) {
      System.out.println(diarista.getId() + " - " + diarista.getNome());
    } else {
      System.err.println("Diarista não encontrada");
    }

  }

  private static void cadastrarDiarista(Scanner scanner, DiaristaRepository repository) {
    System.out.print("Nome: ");
    var nome = scanner.nextLine();

    System.out.print("Telefone: ");
    var telefone = scanner.nextLine();

    System.out.print("cpf: ");
    var cpf = scanner.nextLine();

    System.out.print("endereco: ");
    var endereco = scanner.nextLine();

    var diarista = new Diarista(nome, telefone, cpf, endereco);

    repository.cadastrar(diarista);

    System.out.println("Diarista cadastrada com sucesso");

  }

  private static void listarDiaristas(DiaristaRepository repository) {
    var diaristas = repository.buscarTodos();

    if (diaristas.isEmpty()) {
      System.out.println("Não existem diaristas cadastrados");
    }

    for (Diarista diarista : diaristas) {
      System.out.println(diarista.getId() + " - " + diarista.getNome());
    }
  }

  private static void exibirMenu() {
    System.out.println("==============================================");
    System.out.println("1 - Listar Diaristas");
    System.out.println("2 - Cadastrar Diaristas");
    System.out.println("3 - Buscar Diaristas");
    System.out.println("4 - Excluir Diaristas");
    System.out.println("q - Excluir Diaristas");

  }
}
