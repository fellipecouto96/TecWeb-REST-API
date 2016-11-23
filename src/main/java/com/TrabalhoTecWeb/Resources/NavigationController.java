package com.TrabalhoTecWeb.Resources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NavigationController {

	@RequestMapping(value="cadastrarClientes",method=RequestMethod.GET)
	public String iniciar(){
		return "view/html/cliente/cadastro_cliente";
	}
	@RequestMapping(value="/exibirClientes",method=RequestMethod.GET)
	public String exibirCliente(){
		return "view/html/cliente/exibir_cliente";
	}
	@RequestMapping(value="/alterarClientes",method=RequestMethod.GET)
	public String alterarCliente(){
		return "view/html/cliente/editar_cliente";
	}
	
	@RequestMapping(value="/exibirEvento",method=RequestMethod.GET)
	public String exibirEvento(){
		return "view/html/evento/exibir";
	}
	
	@RequestMapping(value="/cadastrarEvento",method=RequestMethod.GET)
	public String cadastrarEvento(){
		return "view/html/evento/cadastro";
	}
	
	@RequestMapping(value="/exibirIngresso",method=RequestMethod.GET)
	public String exibirIngresso(){
		return "view/html/ingresso/exibir";
	}
	
	@RequestMapping(value="/cadastrarIngresso",method=RequestMethod.GET)
	public String cadastrarIngresso(){
		return "view/html/ingresso/cadastro";
	}
	
	@RequestMapping(value="/comprar",method=RequestMethod.GET)
	public String comprar(){
		return "view/html/compra/cadastro_compra";
	}
	
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(){
		return "view/home";
	}
	
	
	
}
