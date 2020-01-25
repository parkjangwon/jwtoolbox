package in.parkjw.jwtoolbox.service.formatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pjw
 * JSON Formatting 관련 비즈니스 로직 수행 클래스
 */
@Service
public class JsonUtilImpl implements JsonUtil {

	@Override
	public String formatter(String str) {

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

		/**
		 * Test Json String (compact)
		 * {"name":"pjw","gender":"man","age":"29","email":"vim@kakao.com"}
		 * {name:"pjw",gender:"man",age:"29",email:"vim@kakao.com"}
		 */
		String resultStr;
		Map<String, Object> map = new HashMap<>();

		if (!"".equals(str) && str.length() > 0) {
			try {
				map = mapper.readValue(str, new TypeReference<Map<String, Object>>(){});
				resultStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
			} catch (JsonProcessingException e) {
				resultStr = "ERROR! check Input Data.";
				e.printStackTrace();
			}
		} else {
			resultStr = "NO DATA!";
		}
		return resultStr;
	}
	@Override
	public String formatter(Map<String, Object> map) {

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

		/**
		 * Test Json String (compact)
		 * {"name":"pjw","gender":"man","age":"29","email":"vim@kakao.com"}
		 * {name:"pjw",gender:"man",age:"29",email:"vim@kakao.com"}
		 */
		String resultStr;

		if (map.size() > 0) {
			try {
				resultStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
			} catch (JsonProcessingException e) {
				resultStr = "ERROR! check Input Data.";
				e.printStackTrace();
			}
		} else {
			resultStr = "NO DATA!";
		}
		return resultStr;
	}
}
