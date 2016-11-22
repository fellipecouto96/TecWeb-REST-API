import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/clientes")
public class ClienteController {

//	@RequestMapping
//	public ModelAndView iniciar(){
//		ModelAndView mv = new ModelAndView("PesquisaTitulos");
//		
//		mv.addObject("titulos",tituloService.pesquisarTitulo(filtro));
//		return mv;
//	}
}
