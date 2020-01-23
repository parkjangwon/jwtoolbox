package in.parkjw.jwtoolbox.ctl.encoder;

import in.parkjw.jwtoolbox.service.encoder.Base64Util;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author pjw
 * Base64 인코딩, 디코딩 관련 컨트롤러 객체
 */
@RestController
public class Base64UtilCtl {

	/*
	 * 비즈니스 로직을 수행하는 Base64UtilImpl은 Base64Util 인터페이스를 구현한 Service 객체이므로,
	 * Base64Util Interface 객체를 Autowired 할 경우, 자동으로 Spring Bean 등록이 된다.
	 */
	@Autowired
	private Base64Util base64Util;

	@PostMapping("/encoder/base64.json")
	@ResponseBody
	public Map<String, Object> encoder(@RequestParam(required = false, value = "str") String str){
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", false);

		try {
			String encodeStr = base64Util.encoder(str);
			resultMap.put("str", encodeStr);
			resultMap.put("result", true);
		} catch (Exception e) {
			resultMap.put("str", "ERROR!");
			e.printStackTrace();
		}
		return resultMap;
	}

	@PostMapping("/decoder/base64.json")
	@ResponseBody
	public Map<String, Object> decoder(@RequestParam(required = false, value = "str") String str){
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", false);

		try {
			String decodeStr = base64Util.decoder(str);
			resultMap.put("str", decodeStr);
			resultMap.put("result", true);
		} catch (Exception e) {
			resultMap.put("str", "ERROR!");
			e.printStackTrace();
		}
		return resultMap;
	}
}