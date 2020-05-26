package in.parkjw.jwtoolbox.service.formatter.xml;

import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author pjw
 * XML Formatting 관련 비즈니스 로직 수행 클래스
 */
@Service
public class XmlUtilImpl implements XmlUtil {

	@Override
	public String formatter(String str, String indent) {

		/*
		 * 모든 개행을 제거 후, "><"  사이에 스페이스가 1개 이상 포함될 때 공백을 제거한다.
		 */
		str = str.replaceAll("\\n", "").replaceAll(">( )+<", "><");

		String resultStr = "";
		boolean tabIndent = false;

		if (indent.equals("tab")) {
			tabIndent = true;
		}

		try {
			Transformer serializer = SAXTransformerFactory.newInstance().newTransformer();
			Source parseXml = new SAXSource(new InputSource(new ByteArrayInputStream(str.getBytes())));
			StreamResult resultXml = new StreamResult(new ByteArrayOutputStream());

			serializer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			serializer.setOutputProperty(OutputKeys.METHOD, "xml");
			serializer.setOutputProperty(OutputKeys.INDENT, "yes");
			serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

			if (tabIndent) {
				serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			} else {
				serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", indent);
			}

			serializer.transform(parseXml, resultXml);

			resultStr = new String(((ByteArrayOutputStream) resultXml.getOutputStream()).toByteArray());

			if (tabIndent) {
				resultStr = resultStr.replace("\n  ", "\n\t");
			}

		} catch (Exception e) {
			resultStr = "NO DATA. or Check Input.";
		}

		return resultStr;
	}
}
