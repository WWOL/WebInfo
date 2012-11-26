package mccarthy.brian.webinfo.html.part;

/**
 * 
 * @author Brian McCarthy
 *
 */
public interface HTMLPart {
	
	public static String NEW_LINE = "\r\n";
	
	public enum Type {
		HEADER,
		PRE,
		WELCOME,
		ERROR,
		BODY,
		BODY_GROUP,
		INFO,
		STATUS,
		POST;
	}
	
	public Type getType();
	
	public String getStringPart();
	
}
