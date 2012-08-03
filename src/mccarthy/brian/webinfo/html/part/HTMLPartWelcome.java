package mccarthy.brian.webinfo.html.part;

/**
 * 
 * @author Brian McCarthy
 *
 */
public class HTMLPartWelcome implements HTMLPart {

	private String part = "";

	public HTMLPartWelcome() {
		part = "<h1>Welcome to WebInfo</h1>";
		//TODO Add welcome image? Slow.
	}

	@Override
	public Type getType() {
		return Type.WELCOME;
	}

	@Override
	public String getStringPart() {
		return part;
	}

	@Override
	public int getWeight() {
		return 2;
	}

}
