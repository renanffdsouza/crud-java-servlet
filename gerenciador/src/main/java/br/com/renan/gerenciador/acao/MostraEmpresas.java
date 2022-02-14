package br.com.renan.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renan.gerenciador.servlet.modelo.Banco;
import br.com.renan.gerenciador.servlet.modelo.Empresa;

public class MostraEmpresas {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		
		Empresa empresa = banco.buscaEmpresaPeloId(id);
		
		request.setAttribute("empresa", empresa);
		return "forward:formAlteraEmpresa.jsp";
		
	}
}
