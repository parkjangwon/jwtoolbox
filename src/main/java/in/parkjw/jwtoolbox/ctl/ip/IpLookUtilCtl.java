package in.parkjw.jwtoolbox.ctl.ip;

import in.parkjw.jwtoolbox.service.formatter.json.JsonUtil;
import in.parkjw.jwtoolbox.service.ip.lookup.GeoIPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IpLookUtilCtl {

	@Autowired
	private GeoIPService service;

	@Autowired
	private JsonUtil jsonUtil;

	@PostMapping("/ip/lookup.json")
	@ResponseBody
	public Map<String, Object> formatter(@RequestParam(required = false, value = "str") String ip) {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", false);
		Map<String, Object> tmpMap = new HashMap<>();
		String country = "";

		try {
			tmpMap = service.countryInfomation(ip);
			country = jsonUtil.formatter(tmpMap);
			resultMap.put("str", country);
			resultMap.put("latitude", tmpMap.get("latitude"));
			resultMap.put("longitude", tmpMap.get("longitude"));
			resultMap.put("result", true);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("str", "ERROR!");
		}

		return resultMap;
	}
}
