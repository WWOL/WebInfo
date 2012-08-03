package mccarthy.brian.webinfo;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Brian McCarthy
 *
 */
public class ThreadSocketListener extends Thread {
	WebInfo instance;
	ServerSocket sSocket;
	boolean running;
	
	public ThreadSocketListener(WebInfo instance, ServerSocket sSocket) {
		this.instance = instance;
		this.sSocket = sSocket;
		running = true;
	}
	
	public void run() {
		while (running) {
			Socket socket;
			try {
				socket = sSocket.accept();
			} catch (Exception e) {
				continue;
			}
			instance.onNewSocket(socket);
		}
	}
	
	public void shutdown() {
		running = false;
	}
}
