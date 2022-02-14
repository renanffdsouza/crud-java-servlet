package br.com.renan.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renan.gerenciador.acao.AlteraEmpresas;
import br.com.renan.gerenciador.acao.ListaEmpresas;
import br.com.renan.gerenciador.acao.MostraEmpresas;
import br.com.renan.gerenciador.acao.NovaEmpresa;
import br.com.renan.gerenciador.acao.RemoveEmpresas;

@WebServlet("/unicaEntrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");

		if (paramAcao.equals("ListaEmpresas")) {
			ListaEmpresas acao = new ListaEmpresas();
			acao.executa(request, response);

		} else if (paramAcao.equals("RemoveEmpresas")) {
			RemoveEmpresas acao = new RemoveEmpresas();
			acao.executa(request, response);
			
		} else if (paramAcao.equals("MostraEmpresas")) {
			MostraEmpresas acao = new MostraEmpresas();
			acao.executa(request, response);
			
		}else if (paramAcao.equals("AlteraEmpresas")) {
			AlteraEmpresas acao = new AlteraEmpresas();
			acao.executa(request, response);
			
		}else if (paramAcao.equals("NovaEmpresa")) {
			NovaEmpresa acao = new NovaEmpresa();
			acao.executa(request, response);
		}
		
		
	}

}