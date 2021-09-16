package dev.ralfguth.cadastro.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.ralfguth.cadastro.modelo.Autor;

public class AutorDao {

	
	private Connection conexao;
	private String sql;

	public AutorDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void cadastrar(Autor autor) {
		sql = "INSERT INTO autores(nome, email, nascimento, biografia) values(?, ?, ?, ?);";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, autor.getNome());
			ps.setString(2, autor.getEmail());
			ps.setDate(3, Date.valueOf(autor.getNascimento()));
			ps.setString(4, autor.getBio());
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Autor> listar() {
		sql = "SELECT * FROM autores";
		List<Autor> autores = new ArrayList<>();
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Autor autor = new Autor(
						resultSet.getString("nome"),
						resultSet.getString("email"),
						resultSet.getDate("nascimento").toLocalDate(), 
						resultSet.getString("biografia")
						);
				autores.add(autor);
			}
			return autores;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

