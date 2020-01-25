package in.parkjw.jwtoolbox.service.formatter;

import java.util.Map;

/**
 * @author pjw
 * JSON Formatting 관련 인터페이스
 */
public interface JsonUtil {
	public String formatter(String str);
	public String formatter(Map<String, Object> map);
}
