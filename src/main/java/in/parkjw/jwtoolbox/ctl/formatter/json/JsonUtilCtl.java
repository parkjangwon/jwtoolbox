package in.parkjw.jwtoolbox.ctl.formatter.json;

import in.parkjw.jwtoolbox.service.formatter.json.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class JsonUtilCtl {

	@Autowired
	private JsonUtil jsonUtil;

	@PostMapping("/formatter/json.json")
	public Map<String, Object> formatter(@RequestParam(required = false, value = "str") String str) {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", false);
		String jsonFormattedStr = "";

		try {
			jsonFormattedStr = jsonUtil.formatter(str);
			resultMap.put("str", jsonFormattedStr);
			resultMap.put("result", true);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("str", "ERROR!");
		}

		return resultMap;
	}
}
