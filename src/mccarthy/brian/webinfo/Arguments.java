package mccarthy.brian.webinfo;

import java.util.ArrayList;
import java.util.List;

public class Arguments {

	private List<String> args;
	private List<String> unknownArgs;
	public static List<String> ARGUMENTS;
	
	static {
		ARGUMENTS = new ArrayList<String>();
		ARGUMENTS.add("user");
		ARGUMENTS.add("pass");
		ARGUMENTS.add("info");
		ARGUMENTS.add("close");
		ARGUMENTS.add("shutdown");
	}
	
	public Arguments(String[] argsArray) {
		args = new ArrayList<String>();
		unknownArgs = new ArrayList<String>();
		phrase(argsArray);
	}
	
	public List<String> getArgs() {
		return args;
	}
	
	public List<String> getUnknownArgs() {
		return unknownArgs;
	}
	
	private void phrase(String[] argsArray) {
		for (String arg : argsArray) {
			System.out.println("Pharseing arg: " + arg);
			System.out.println("Pharseing arg2: " + arg);
			if (ARGUMENTS.contains(arg.split("=")[0].toLowerCase())) {
				args.add(arg);
			} else {
				unknownArgs.add(arg);
			}
		}
	}
	
	public List<InfoType> getInfoTypes() {
		List<InfoType> list = new ArrayList<InfoType>();
		for (String string : args) {
			if (string.startsWith("info") && string.split("=").length == 2) {
				try {
					list.add(InfoType.valueOf(string.split("=")[1].toUpperCase()));
				} catch (Exception e) {
					continue;
				}
				
			}
		}
		return list;
	}
	
}
