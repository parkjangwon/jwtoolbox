package in.parkjw.jwtoolbox.service.encoder;

/**
 * @author pjw
 * Base64 인코딩, 디코딩 메서드 인터페이스
 */
public interface Base64Util {
	public String encoder(String str);
	public String decoder(String str);
}
