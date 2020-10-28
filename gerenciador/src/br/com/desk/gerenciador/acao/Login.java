package br.com.desk.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.desk.gerenciador.modelo.Banco;
import br.com.desk.gerenciador.modelo.Usuario;

public class Login implements Acao {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("Login");
		String senha = request.getParameter("senha");

		System.out.println("Logando " + login);

		Banco banco = new Banco();
		Usuario usuario = banco.existeUsuario(login, senha);

		if (usuario != null) {
			System.out.println("Usuario existe");
			HttpSession sessao =  request.getSession();//Pega o id do cookie e retorna a sessão
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:entrada?acao=ListaEmpresas";
		} else {
			System.out.println("Usuario não cadastrado ou senha invalida");
			return "redirect:entrada?acao=LoginForm";

		}

	}

}
