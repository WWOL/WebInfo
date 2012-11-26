package mccarthy.brian.webinfo;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Brian McCarthy
 *
 */
public class WebInfo {
	public static final String VERSION = "1.1";
	ServerSocket sSocket;
	int port = 21000;
	
	public static void main(String[] args0) {
		System.out.println("Starting WebInfo.");
		WebInfo webInfo = new WebInfo();
		SysTrayHandler trayHandler = new SysTrayHandler();
		webInfo.listen();
		trayHandler.initSysTray();
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

}
