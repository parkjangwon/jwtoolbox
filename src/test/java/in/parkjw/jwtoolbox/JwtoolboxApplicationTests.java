package in.parkjw.jwtoolbox;

import in.parkjw.jwtoolbox.service.ip.lookup.GeoIPService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JwtoolboxApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private GeoIPService service;

	@Test
	public void test() {
		String countryCode = service.countryIsoCode("tool.parkjw.in");
		System.out.println(countryCode);
	}


}
