package in.parkjw.jwtoolbox.ctl.formatter.sql;

import in.parkjw.jwtoolbox.service.formatter.sql.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SqlUtilCtl {

	@Autowired
	private SqlUtil sqlUtil;

	@PostMapping("/formatter/sql.json")
	public Map<String, Object> formatter(@RequestParam(required = false, value = "str") String str) {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", false);
		String sqlFormattedStr = "";

		try {
			sqlFormattedStr = sqlUtil.formatter(str);
			resultMap.put("str", sqlFormattedStr);
			resultMap.put("result", true);
		} catch (Exception e) {
			resultMap.put("str", "ERROR!");
		}

		return resultMap;
	}
}
