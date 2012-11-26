package mccarthy.brian.webinfo.html;

import java.util.LinkedList;
import java.util.List;

import mccarthy.brian.webinfo.html.part.HTMLPart;

/**
 * 
 * @author Brian McCarthy
 *
 */
public class HTMLConstructer {
	
	private List<HTMLPart> parts;

	public HTMLConstructer() {
		// Use a linked list to keep ordering
		parts = new LinkedList<HTMLPart>();
	}

	public String getFullHTML() {
		StringBuilder sb = new StringBuilder();
		for (HTMLPart part : parts) {
			System.out.println("Part: " + part.getStringPart());
			sb.append(part.getStringPart());
		}
		return sb.toString();
	}

	public void addPart(HTMLPart part) {
		parts.add(part);
	}
	
}
