package dev.ralfguth.cadastro.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.ralfguth.cadastro.dao.AutorDao;
import dev.ralfguth.cadastro.factory.ConnectionFactory;
import dev.ralfguth.cadastro.modelo.Autor;

@WebServlet("/autores")
public class CadastroServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private AutorDao dao;

	public CadastroServlet() {
		dao = new AutorDao(new ConnectionFactory().connect());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("autores", dao.listar());
		req.getRequestDispatcher("WEB-INF/jsp/cadastroDeAutores.jsp").forward(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String nome = req.getParameter("nome");
			String email = req.getParameter("email");
			LocalDate nascimento = LocalDate.parse(req.getParameter("nascimento"));
			String bio = req.getParameter("biografia");
			Autor autor = new Autor(nome, email, nascimento, bio);
			dao.cadastrar(autor);
			res.sendRedirect("autores");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
