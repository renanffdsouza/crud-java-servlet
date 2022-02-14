package br.com.renan.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renan.gerenciador.servlet.modelo.Banco;

public class RemoveEmpresas {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println(id);
		
		Banco banco = new Banco();
		banco.removeEmpresa(id);
		
		response.sendRedirect("unicaEntrada?acao=ListaEmpresas");
	}
}
