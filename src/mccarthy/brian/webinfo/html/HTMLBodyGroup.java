package mccarthy.brian.webinfo.html;

import java.util.ArrayList;
import java.util.List;

import mccarthy.brian.webinfo.html.part.HTMLPart;
import mccarthy.brian.webinfo.html.part.HTMLPartBody;

public class HTMLBodyGroup implements HTMLPart {

	private List<HTMLPartBody> list;

	public HTMLBodyGroup() {
		list = new ArrayList<HTMLPartBody>();
	}

	public void addPart(HTMLPartBody part) {
		list.add(part);
	}

	@Override
	public Type getType() {
		return Type.BODY_GROUP;
	}

	@Override
	public String getStringPart() {
		StringBuilder sb = new StringBuilder();
		for (HTMLPartBody part : list) {
			sb.append(part.getStringPart());
		}
		return sb.toString();
	}
	
}
