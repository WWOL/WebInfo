package mccarthy.brian.webinfo.html.part;

/**
 * 
 * @author Brian McCarthy
 *
 */
public class HTMLPartWelcome implements HTMLPart {

	private String part = "";

	public HTMLPartWelcome() {
		part = "<h1>Welcome to <font color=Lime>WebInfo</font></h1><h6><a href=http://wwol.github.com>By Brian McCarthy (WWOL)</a></h6><br />";
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

}
