package in.parkjw.jwtoolbox.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToolNavigatorCtl {

	@GetMapping("tools/encoder")
	public String encoder(){
		return "tools/encoder";
	}

	@GetMapping("tools/formatter/json")
	public String jsonFormatter(){
		return "tools/formatter/json";
	}

	@GetMapping("tools/formatter/xml")
	public String xmlFormatter(){
		return "tools/formatter/xml";
	}

	@GetMapping("tools/iplookup")
	public String iplookup(){
		return "tools/iplookup";
	}
}
