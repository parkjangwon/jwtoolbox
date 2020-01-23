package in.parkjw.jwtoolbox.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexCtl {

	@GetMapping("/")
	public String main (){
		return "main/index";
	}
}
