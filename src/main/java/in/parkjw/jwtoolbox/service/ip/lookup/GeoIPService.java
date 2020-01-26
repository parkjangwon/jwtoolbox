package in.parkjw.jwtoolbox.service.ip.lookup;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.*;

public class GeoIPService {

	private DatabaseReader reader;

	public GeoIPService(DatabaseReader geoIpDatabaseReader) {
		this.reader = geoIpDatabaseReader;
	}

	public CountryResponse countryResponse(InetAddress inetAddress) {
		try {
			return reader.country(inetAddress);
		} catch (IOException | GeoIp2Exception e) {
		}

		return null;
	}

	public CountryResponse countryResponse(String ipAddress) {
		InetAddress inetAddress;
		try {
			inetAddress = InetAddress.getByName(ipAddress);
			return countryResponse(inetAddress);
		} catch (UnknownHostException e) {
		}
		return null;
	}

	public CityResponse cityResponse(InetAddress inetAddress) {
		try {
			return reader.city(inetAddress);
		} catch (IOException | GeoIp2Exception e) {
		}

		return null;
	}

	public CityResponse cityResponse(String ipAddress) {
		InetAddress inetAddress;
		try {
			inetAddress = InetAddress.getByName(ipAddress);
			return cityResponse(inetAddress);
		} catch (UnknownHostException e) {
		}
		return null;
	}


	public String countryIsoCode(String ipAddress) {
		String result = "";
		CountryResponse countryResponse = countryResponse(ipAddress);
		if(countryResponse != null) {
			result =  countryResponse.getCountry().getIsoCode();
		} else {
			result = "Invalid IpAdress. Check Input IpAddress";
		}
		return result;
	}

	public String countryIsoCode(InetAddress inetAddress) {
		String result = "";
		CountryResponse countryResponse = countryResponse(inetAddress);

		if(countryResponse != null) {
			result =  countryResponse.getCountry().getIsoCode();
		} else {
			result = "Invalid IpAdress. Check Input IpAddress";
		}
		return result;
	}

	public Map<String, Object> countryInfomation(String ipAddress) {

		Map<String, Object> resultMap = new HashMap<>();
		CityResponse cityResponse = cityResponse(ipAddress);
		if(cityResponse != null) {
			Country country = cityResponse.getCountry();
			resultMap.put("result", true);
			resultMap.put("countryIsoCode", country.getIsoCode());            // 'US'
			resultMap.put("countryName", country.getName());               // 'United States'

			Subdivision subdivision = cityResponse.getMostSpecificSubdivision();
			resultMap.put("subdivisionIsocode", subdivision.getIsoCode()); // 'MN'
			resultMap.put("subdivisionName", subdivision.getName());    // 'Minnesota'

			Location location = cityResponse.getLocation();
			resultMap.put("latitude", location.getLatitude());  // 44.9733
			resultMap.put("longitude", location.getLongitude()); // -93.2323

			City city = cityResponse.getCity();
			resultMap.put("cityName", city.getName()); // 'Minneapolis'

			Postal postal = cityResponse.getPostal();
			resultMap.put("postalCode", postal.getCode()); // '55455'

			return resultMap;

		} else {
			resultMap.put("result", false);
			resultMap.put("cause", "Invalid IpAdress. Check Input IpAddress");
			return resultMap;
		}
	}

}