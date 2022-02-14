package br.com.renan.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renan.gerenciador.servlet.modelo.Banco;
import br.com.renan.gerenciador.servlet.modelo.Empresa;

public class AlteraEmpresas {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data");
		String paramId = request.getParameter("id");
		Integer Id = Integer.valueOf(paramId);

		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(dataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPeloId(Id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		return "redirect:unicaEntrada?acao=ListaEmpresas";

	}
}
