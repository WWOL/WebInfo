package mccarthy.brian.webinfo.html.part;

import mccarthy.brian.webinfo.html.HTMLStatus;

/**
 * 
 * @author Brian McCarthy
 *
 */
public class HTMLPartStatus implements HTMLPart {

	private String part = "";

	public HTMLPartStatus(HTMLStatus status) {
		
		part = "<br /><br />Status: %s (%s)";
		part = String.format(part, status.getCode(), status.getMsg());
	}

	@Override
	public Type getType() {
		return Type.STATUS;
	}

	@Override
	public String getStringPart() {
		return part;
	}

	@Override
	public int getWeight() {
		return 4;
	}

}
