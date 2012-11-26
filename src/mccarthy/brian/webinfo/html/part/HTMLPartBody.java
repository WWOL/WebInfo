package mccarthy.brian.webinfo.html.part;

/**
 * 
 * @author Brian McCarthy
 *
 */
public class HTMLPartBody implements HTMLPart {

	private String part = "";

	public HTMLPartBody(String title, String... lines) {
		StringBuilder sb = new StringBuilder();
		sb.append("<h2><font color=Blue>" + title + "</font></h2>");
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

}
