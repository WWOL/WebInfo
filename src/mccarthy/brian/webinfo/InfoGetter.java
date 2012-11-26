package mccarthy.brian.webinfo;

import java.io.File;

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
			sb.append(formatBytes(Runtime.getRuntime().maxMemory()));
			sb.append("<br />Free Memory: ");
			sb.append(formatBytes(Runtime.getRuntime().freeMemory()));
			sb.append("<br />Total Memory: ");
			sb.append(formatBytes(Runtime.getRuntime().totalMemory()));
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
			File file = File.listRoots()[0];
			sb.append("Free Space: ");
			sb.append(formatBytes(file.getFreeSpace()));
			sb.append("<br /> Total Space: ");
			sb.append(formatBytes(file.getTotalSpace()));
			sb.append("<br /> Usable Space: ");
			sb.append(formatBytes(file.getUsableSpace()));
			break;
		case ALL:
			for (InfoType info : InfoType.values()) {
				if (info == InfoType.ALL) {
					// Avoid StackOverflowException
					continue;
				}
				sb.append(getInfo(info));
				sb.append("<br /><br />");
			}
			break;
		default:
			sb.append("UNIPLIMENTED TYPE!");
			break;
		}
			
		return sb.toString();
	}

	/**
	 * Format bytes into a readable format
	 * @param bytes
	 * @return Bytes as B, KB, MB, GB or TB. Return original as bytes if over 1024 TB.  
	 */
	public static String formatBytes(long bytes) {
		long originalBytes = bytes;
		String[] types = new String[]{" (B)", " (KB)", " (MB)", " (GB)", " (TB)"};
		
		int index = 0;
		
		while (bytes > 1024) {
			bytes /= 1024;
			index++;
		}
		String suffix = "";
		try {
			suffix = types[index];
		} catch (Exception e) {
			return originalBytes + types[0];
		}
		return bytes + suffix;//*/
	}
	
}
