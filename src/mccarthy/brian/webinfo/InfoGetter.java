package mccarthy.brian.webinfo;

/**
 * 
 * @author Brian McCarthy
 *
 */
public class InfoGetter {
	
	public static String getInfo(InfoType type) {
		StringBuilder sb = new StringBuilder();
		switch(type) {
		case RAM:
			sb.append("Max Memory: ");
			sb.append(Runtime.getRuntime().maxMemory() / 1024 / 1024);
			sb.append(" (MB)");
			sb.append("<br />Free Memory: ");
			sb.append(Runtime.getRuntime().freeMemory() / 1024 / 1024);
			sb.append(" (MB)");
			sb.append("<br />Total Memory: ");
			sb.append(Runtime.getRuntime().totalMemory() / 1024 / 1024);
			sb.append(" (MB)");
			break;
		case CPU:
			sb.append("Processors: ");
			sb.append(Runtime.getRuntime().availableProcessors());
			break;
		case JAVA:
			sb.append("Java Version: ");
			sb.append(System.getProperty("java.version"));
			break;
		case OS:
			sb.append("OS: ");
			sb.append(System.getProperty("os.name"));
			sb.append("<br />User Name: ");
			sb.append(System.getProperty("user.name"));
			break;
		case HDD:
			sb.append("HDD IS UNIPLIMENTED!");
			break;
		default:
			sb.append("UNIPLIMENTED TYPE!");
		}
			
		return sb.toString();
	}
	
}
