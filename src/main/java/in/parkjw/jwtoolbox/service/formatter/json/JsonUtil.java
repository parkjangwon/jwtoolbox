package in.parkjw.jwtoolbox.service.formatter.json;

import java.util.Map;

/**
 * @author pjw
 * JSON Formatting 관련 인터페이스
 */
public interface JsonUtil {
	String formatter(String str);
	String formatter(Map<String, Object> map);
}
