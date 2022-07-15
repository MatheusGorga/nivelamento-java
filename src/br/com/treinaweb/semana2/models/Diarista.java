package br.com.treinaweb.semana2.models;

public class Diarista extends Pessoa {

  public Diarista() {
  }

  public Diarista(String nome, String telefone, String cpf, String endereco, Long id) {
    super(nome, telefone, cpf, endereco, id);
  }

  public Diarista(String nome, String telefone, String cpf, String endereco) {
    super(nome, telefone, cpf, endereco, null);
  }

}
