package mccarthy.brian.webinfo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;

import mccarthy.brian.webinfo.html.HTMLBodyGroup;
import mccarthy.brian.webinfo.html.HTMLConstructer;
import mccarthy.brian.webinfo.html.HTMLErrorPage;
import mccarthy.brian.webinfo.html.HTMLStatus;
import mccarthy.brian.webinfo.html.part.HTMLPartBody;
import mccarthy.brian.webinfo.html.part.HTMLPartHeader;
import mccarthy.brian.webinfo.html.part.HTMLPartPost;
import mccarthy.brian.webinfo.html.part.HTMLPartPre;
import mccarthy.brian.webinfo.html.part.HTMLPartStatus;
import mccarthy.brian.webinfo.html.part.HTMLPartWelcome;

/**
 * 
 * @author Brian McCarthy
 *
 */
public class ThreadSocketReader extends Thread implements Shutdown {
	WebInfo instance;
	Socket socket;
	BufferedReader reader;
	BufferedWriter writer;
	boolean running;
	
	public ThreadSocketReader(WebInfo instance, Socket socket) {
		super("ThreadSocketReader_" + socket);
		this.instance = instance;
		this.socket = socket;
		this.running = true;
	}

	public void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (Exception e) {
			running = false;
		}
		while(running) {
			String line = null;
		    try {
				line = reader.readLine();
			} catch (Exception e) {
				running = false;
			}
		    if (line == null) {
		    	running = false;
		    }
		    process(line);
		}
	}
	
	private void process(String line) {
		if (line == null) {
			return;
		}
		System.out.println(line);
		if (line.startsWith("GET")) {
			if (line.equalsIgnoreCase("GET / HTTP/1.1")) {
				write(new HTMLErrorPage(HTMLStatus.BAD_REQUEST).getFullHTML());
				return;
			}
			line = line.substring(6, line.length() - 9);
			String[] args = line.split("&");
			for (String arg : args) {
				System.out.println("Arg: " + arg);
			}
			System.out.println("Found GET: " + line);
			Arguments arguments = new Arguments(args);
			sendInfo(arguments);
		}
	}
	
	public void sendInfo(Arguments args) {
		System.out.println("Known args: " + args.getArgs().size());
		System.out.println("Unknown args: " + args.getUnknownArgs().size());
		HTMLConstructer html = new HTMLConstructer();
		HTMLStatus status = HTMLStatus.OK;
		HTMLPartHeader header = new HTMLPartHeader(status);
		HTMLPartPre pre = new HTMLPartPre();
		HTMLPartWelcome welcome = new HTMLPartWelcome();
		HTMLBodyGroup bodyGroup = new HTMLBodyGroup();
		HTMLPartStatus bodyStatus;
		HTMLPartPost post = new HTMLPartPost();
		
		List<InfoType> infos = args.getInfoTypes();
		for (InfoType type : infos) {
			System.out.println("InfoType: " + type.name());
			String bodyText = InfoGetter.getInfo(type);
			System.out.println("BodyText: " + bodyText);
			HTMLPartBody body = new HTMLPartBody(type.name(), bodyText);
			bodyGroup.addPart(body);
		}
		
		if (args.getArgs().isEmpty()) {
			status = HTMLStatus.BAD_REQUEST;
		}
		
		bodyStatus = new HTMLPartStatus(status);
		
		html.addPart(header);
		html.addPart(pre);
		html.addPart(welcome);
		html.addPart(bodyGroup);
		html.addPart(bodyStatus);
		html.addPart(post);
		
		
		write(html.getFullHTML());
	}
	
	public void write(String line) {
	    try {
	    	writer.write(line);
	    	writer.flush();
	    	writer.close();
	    } catch (Exception e) {
	    	return;
	    }
	}

	@Override
	public void shutdown() {
		running = false;
	}
	
}
