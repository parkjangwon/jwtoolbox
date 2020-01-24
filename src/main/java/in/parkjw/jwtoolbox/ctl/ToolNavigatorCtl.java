package in.parkjw.jwtoolbox.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToolNavigatorCtl {

	@GetMapping("tools/encoder")
	public String encoder(){
		return "tools/encoder";
	}

	@GetMapping("tools/formatter")
	public String formatter(){
		return "tools/formatter";
	}

	@GetMapping("tools/iplookup")
	public String iplookup(){
		return "tools/iplookup";
	}
}
