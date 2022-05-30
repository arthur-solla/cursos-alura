package br.com.alura.mvc.mudi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Pedido;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Kindle 10a");
		pedido.setUrlImagem("https://m.media-amazon.com/images/I/61X0ISBpD-L._AC_SY450_.jpg");
		pedido.setUrlProduto("https://www.amazon.com.br/gp/product/B07FQK1TS9?ref_=gw_ATF_kindle&pf_rd_r=T07GTSCJPWAZMH8ANSC4&pf_rd_p=1432da46-f2c5-49b4-b7c3-3b9ddfcfee00&pd_rd_r=61d51ef7-4732-42da-925e-e4c81b9aff6f&pd_rd_w=zcnIz&pd_rd_wg=jxiWE&th=1");
		pedido.setDescricao("Kindle 10a. geração com bateria de longa duração - Cor Preta");
		
		List<Pedido> pedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos", pedidos);
		
		return"home";
	}
	
}
