package mccarthy.brian.webinfo.html.part;

/**
 * 
 * @author Brian McCarthy
 *
 */
public class HTMLPartPost implements HTMLPart {

	private String part = "";

	public HTMLPartPost() {
		
		part = "</p></body></html>";
	}

	@Override
	public Type getType() {
		return Type.POST;
	}

	@Override
	public String getStringPart() {
		return part;
	}

}
