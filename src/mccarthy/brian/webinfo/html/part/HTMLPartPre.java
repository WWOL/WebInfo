package mccarthy.brian.webinfo.html.part;

import mccarthy.brian.webinfo.WebInfo;

/**
 * 
 * @author Brian McCarthy
 *
 */
public class HTMLPartPre implements HTMLPart {

	private String part = "";

	public HTMLPartPre() {
		part = "<html><head><title>WebInfo V: " + WebInfo.VERSION + "</title></head><body><p>";
	}

	@Override
	public Type getType() {
		return Type.PRE;
	}

	@Override
	public String getStringPart() {
		return part;
	}

}
