package in.parkjw.jwtoolbox.ctl.ip;

import in.parkjw.jwtoolbox.service.iplookup.GeoIPService;
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

	@PostMapping("/ip/lookup.json")
	@ResponseBody
	public Map<String, Object> formatter(@RequestParam(required = false, value = "str") String ip) {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", false);
		String isocode = "";

		try {
			isocode = service.countryIsoCode(ip);
			resultMap.put("str", isocode);
			resultMap.put("result", true);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("str", "ERROR!");
		}

		return resultMap;
	}
}
