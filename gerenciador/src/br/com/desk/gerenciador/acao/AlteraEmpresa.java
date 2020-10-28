package br.com.desk.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.desk.gerenciador.modelo.Banco;
import br.com.desk.gerenciador.modelo.Empresa;

public class AlteraEmpresa implements Acao {

	
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("dataAbertura");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		
		

		System.out.println("Açao altera empresas " + id);
	 	
		
		
		Date dataAbertura =  null;
		//formata pelo pattern fmt
	
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		System.out.println(id);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPelaId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		return"redirect:entrada?acao=ListaEmpresas";
	}
	
}
