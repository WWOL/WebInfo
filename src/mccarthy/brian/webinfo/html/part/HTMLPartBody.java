package mccarthy.brian.webinfo.html.part;

import mccarthy.brian.webinfo.WebInfo;

/**
 * 
 * @author Brian McCarthy
 *
 */
public class HTMLPartBody implements HTMLPart {

	private String part = "";

	public HTMLPartBody(String title, String... lines) {
		StringBuilder sb = new StringBuilder();
		sb.append("<h2>" + title + "</h2>");
		for (String line : lines) {
			sb.append(line);
			sb.append("<br />");
		}
		sb.append("<br />");
		part = sb.toString();
	}

	@Override
	public Type getType() {
		return Type.BODY;
	}

	@Override
	public String getStringPart() {
		return part;
	}

	@Override
	public int getWeight() {
		return 3;
	}

}
