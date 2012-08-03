package mccarthy.brian.webinfo.html;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mccarthy.brian.webinfo.WebInfo;
import mccarthy.brian.webinfo.html.part.HTMLPart;

/**
 * 
 * @author Brian McCarthy
 *
 */
public class HTMLConstructer {
	
	private List<HTMLPart> parts;

	public HTMLConstructer() {
		parts = new ArrayList<HTMLPart>();
	}

	public String getFullHTML() {
		//TODO MAKE WEIGHT WORK!!!
		StringBuilder sb = new StringBuilder();
		//HTMLPart[] array = parts.toArray(new HTMLPart[]{});
		//array = orderParts(array);
		for (HTMLPart part : parts) {
			System.out.print(part.getWeight() + ", ");
			System.out.println("Part: " + part.getStringPart());
			sb.append(part.getStringPart());
		}
		return sb.toString();
	}

	public void addPart(HTMLPart part) {
		parts.add(part);
	}

	public static HTMLPart[] orderParts(HTMLPart[] paramPartArray) {
		for (int i = 0; i < paramPartArray.length - 1; i++) {
			if (paramPartArray[i].getWeight() > paramPartArray[i + 1].getWeight()){
				HTMLPart tmp = paramPartArray[i + 1];
				paramPartArray[i + 1] = paramPartArray[i];
				paramPartArray[i] = tmp;
				orderParts(paramPartArray);
			}// end if
		}// end for
		return paramPartArray;
	}// end orderNumbers
}
