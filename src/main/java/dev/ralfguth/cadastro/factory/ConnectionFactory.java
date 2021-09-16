package dev.ralfguth.cadastro.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private String url;
	private String usuario;
	private String senha;

	public Connection connect() {
		try {
			url = "jdbc:postgresql://localhost:5434/cadastroautores";
			usuario = "bootcamp";
			senha = "123456";
			Class.forName("org.postgresql.Driver");
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			return conexao;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
