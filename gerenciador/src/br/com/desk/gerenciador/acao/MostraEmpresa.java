package br.com.desk.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.desk.gerenciador.modelo.Banco;
import br.com.desk.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {

	
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("mostrando empresas");
		
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco =  new Banco();
		
		Empresa empresa = banco.buscaEmpresaPelaId(id);
		
		
		System.out.println(empresa.getNome());
		
		request.setAttribute("empresa", empresa);
		
		return"forward:/formAlteraEmpresa.jsp";
		
	}
	
}
