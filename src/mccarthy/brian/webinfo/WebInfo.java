package mccarthy.brian.webinfo;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import mccarthy.brian.webinfo.html.HTMLConstructer;

/**
 * 
 * @author Brian McCarthy
 *
 */
public class WebInfo {
	public static final String VERSION = "1.0";
	ServerSocket sSocket;
	int port = 21000;
	
	public static void main(String[] args0) {
		System.out.println("Starting WebInfo.");
		WebInfo webInfo = new WebInfo();
		SysTrayHandler trayHandler = new SysTrayHandler();
		webInfo.listen();
		trayHandler.initSysTray(webInfo);
	}

	public void listen() {
		try {
			sSocket = new ServerSocket(port);
		} catch (Exception e) {
			e.printStackTrace(); //TODO
			return;
		}
		System.out.println("Starting socket listener on port " + port + ".");
		ThreadSocketListener listener = new ThreadSocketListener(this, sSocket);
		listener.start();
	}

	public void onNewSocket(Socket socket) {
		System.out.println("Starting socket reader.");
		ThreadSocketReader reader = new ThreadSocketReader(this, socket);
		reader.start();
		//TODO Add a list of all current sockets?
	}
	
	public void sendInfo(Socket socket) {
		HTMLConstructer html = new HTMLConstructer();
		System.out.println("========================================================");
		System.out.println("Sending info");
		System.out.println("DATA: " + html.getFullHTML());
		System.out.println("========================================================");
		BufferedWriter writer;
	    try {
	    	writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	    	writer.write(html.getFullHTML());
	    	writer.flush();
	    	writer.close();
	    } catch (Exception e) {
	    	return;
	    }
	}
	
	public String getInfo() {
		StringBuilder toRet = new StringBuilder();
		
		toRet.append("Deprecated! Use getInfo(InfoType)");
		
		return toRet.toString();
	}
	
}
