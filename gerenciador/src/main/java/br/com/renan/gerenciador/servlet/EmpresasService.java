package br.com.renan.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.renan.gerenciador.servlet.modelo.Banco;
import br.com.renan.gerenciador.servlet.modelo.Empresa;


@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Empresa> empresas = new Banco().getEmpresa();
		Gson gson = new Gson();
		String json = gson.toJson(empresas);
		response.setContentType("application/json");
		response.getWriter().print(json);
		
//		XStream xstrem = new XStream();
//		String xml = xstrem.toXML(empresas);
//		xstrem.alias("empresa", Empresa.class);
//		response.setContentType("application/xml");
//		response.getWriter().print(xml);
	}

}
