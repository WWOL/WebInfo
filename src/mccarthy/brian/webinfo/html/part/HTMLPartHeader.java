package mccarthy.brian.webinfo.html.part;

import java.util.Date;

import mccarthy.brian.webinfo.WebInfo;
import mccarthy.brian.webinfo.html.HTMLStatus;

/**
 * 
 * @author Brian McCarthy
 *
 */
public class HTMLPartHeader implements HTMLPart {

	private String part = "";
	
	public HTMLPartHeader(HTMLStatus status) {
		Date date = new Date();
		
		StringBuilder sb = new StringBuilder();
		sb.append("HTTP/1.1");
		sb.append(status.getCode());
		sb.append(" ");
		sb.append(status.getMsg());
		sb.append(NEW_LINE);
		sb.append("Date: ");
		sb.append(date);
		sb.append(NEW_LINE);
		sb.append("Server: WebInfo (V:" + WebInfo.VERSION + ")\r\n");
		sb.append(WebInfo.VERSION);
		sb.append(")");
		sb.append(NEW_LINE);
		sb.append("Last-Modified: ");
		sb.append(date);
		sb.append(NEW_LINE);
		sb.append("Etag: \"3f80f-1b6-3e1cb03b\"\r\n");
		sb.append("Accept-Ranges:  none\r\n");
		sb.append("Content-Length: 438\r\n");
		sb.append("Connection: keep-alive\r\n");
		sb.append("Content-Type: text/html; charset=UTF-8");
		sb.append(NEW_LINE);
		sb.append(NEW_LINE);
		part = sb.toString();
	}
	
	@Override
	public HTMLPart.Type getType() {
		return HTMLPart.Type.HEADER;
	}

	@Override
	public String getStringPart() {
		return part;
	}

	@Override
	public int getWeight() {
		return 0;
	}
 
}
