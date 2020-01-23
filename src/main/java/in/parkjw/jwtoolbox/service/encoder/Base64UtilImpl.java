package in.parkjw.jwtoolbox.service.encoder;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

/**
 * @author pjw
 * Base64 인코딩, 디코딩 비즈니스 로직 수행 클래스
 */
@Service
public class Base64UtilImpl implements Base64Util {
	@Override
	public String encoder(String str) {
		String encodeStr = "";

		try {
			byte[] encoderBytes = Base64.encodeBase64(str.getBytes());
			encodeStr = new String(encoderBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	return encodeStr;
	}

	@Override
	public String decoder(String str) {
		String decodeStr = "";

		try {
			byte[] decoderBytes = Base64.decodeBase64(str.getBytes());
			decodeStr = new String(decoderBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decodeStr;
	}
}
