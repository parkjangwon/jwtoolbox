package in.parkjw.jwtoolbox.ctl.formatter.xml;

import in.parkjw.jwtoolbox.service.formatter.xml.XmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class XmlUtilCtl {

	@Autowired
	private XmlUtil xmlUtil;

	@PostMapping("/formatter/xml.json")
	public Map<String, Object> formatter(@RequestParam(required = false, value = "indent") String indent, @RequestParam(required = false, value = "str") String str) {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", false);
		String xmlFormattedStr = "";

		try {
			xmlFormattedStr = xmlUtil.formatter(str, indent);
			resultMap.put("str", xmlFormattedStr);
			resultMap.put("result", true);
		} catch (Exception e) {
			resultMap.put("str", "ERROR!");
		}

		return resultMap;
	}
}
