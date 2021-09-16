package dev.ralfguth.cadastro.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Autor {

	private String nome;
	private String email;
	private LocalDate nascimento;
	private String biografia;

	public Autor(String nome, String email, LocalDate nascimento, String biografia) {
		this.nome = nome;
		this.email = email;
		this.nascimento = nascimento;
		this.biografia = biografia;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}
	public String getNascimentoFormatado() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return nascimento.format(formatter);
	}
	
	public String getBio() {
		return biografia;
	}	

}
