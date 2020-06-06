package in.parkjw.jwtoolbox.service.formatter.sql;

import com.github.vertical_blank.sqlformatter.SqlFormatter;
import org.springframework.stereotype.Service;

/**
 * @author pjw
 * SQL Formatting 관련 비즈니스 로직 수행 클래스
 */
@Service
public class SqlUtilImpl implements SqlUtil {

	@Override
	public String formatter(String str) {
		return SqlFormatter.of("sql").format(str);
	}
}
