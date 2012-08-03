package mccarthy.brian.webinfo.html;

/**
 * 
 * @author Brian McCarthy
 *
 */
public enum HTMLStatus {
	OK(200, "OK"),
	BAD_REQUEST(400, "Bad Request"),
	FORBIDDEN(403, "Forbidden"),
	NOT_FOUND(404, "Not Found"),
	INTERNAL_ERROR(500, "Internal Server Error");
	
	int code;
	String msg;
	
	HTMLStatus(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMsg() {
		return msg;
	}
}
