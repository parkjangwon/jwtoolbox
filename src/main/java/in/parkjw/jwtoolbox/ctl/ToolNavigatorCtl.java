package in.parkjw.jwtoolbox.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToolNavigatorCtl {

	@GetMapping("tools/encoder")
	public String encoder(){
		return "tools/encoder";
	}

	@GetMapping("tools/jsontool")
	public String jsontool(){
		return "tools/jsontool";
	}
}