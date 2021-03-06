package br.com.renan.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.renan.gerenciador.acao.Acao;
import br.com.renan.gerenciador.acao.AlteraEmpresas;
import br.com.renan.gerenciador.acao.ListaEmpresas;
import br.com.renan.gerenciador.acao.MostraEmpresas;
import br.com.renan.gerenciador.acao.NovaEmpresa;
import br.com.renan.gerenciador.acao.NovaEmpresaForm;
import br.com.renan.gerenciador.acao.RemoveEmpresas;

//@WebServlet(urlPatterns = "/unicaEntrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
		
	

		String nomedaClasse = "br.com.renan.gerenciador.acao." + paramAcao;

		String nome;
		try {
			Class classe = Class.forName(nomedaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}

		String[] tipoEEndereco = nome.split(":");

		if (tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}

//		String nome = null;
//		if (paramAcao.equals("ListaEmpresas")) {
//			ListaEmpresas acao = new ListaEmpresas();
//			nome = acao.executa(request, response);
//
//		} else if (paramAcao.equals("RemoveEmpresas")) {
//			RemoveEmpresas acao = new RemoveEmpresas();
//			nome = acao.executa(request, response);
//
//		} else if (paramAcao.equals("MostraEmpresas")) {
//			MostraEmpresas acao = new MostraEmpresas();
//			nome = acao.executa(request, response);
//
//		} else if (paramAcao.equals("AlteraEmpresas")) {
//			AlteraEmpresas acao = new AlteraEmpresas();
//			nome = acao.executa(request, response);
//
//		} else if (paramAcao.equals("NovaEmpresa")) {
//			NovaEmpresa acao = new NovaEmpresa();
//			nome = acao.executa(request, response);
//		}
//
//		else if (paramAcao.equals("NovaEmpresaForm")) {
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			nome = acao.executa(request, response);
//		}
//

	}

}
