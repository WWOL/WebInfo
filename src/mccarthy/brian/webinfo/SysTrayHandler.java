package mccarthy.brian.webinfo;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class SysTrayHandler implements ActionListener {
	
	private WebInfo instance;
	
	MenuItem menuItem_Close;
	MenuItem menuItem_Version;
	MenuItem menuItem_About;
	
	public void initSysTray(WebInfo instance) {
		this.instance = instance;
		if (SystemTray.isSupported()) {
			SystemTray tray = SystemTray.getSystemTray();
			Image image;
			try {
				image = ImageIO.read(WebInfo.class.getResourceAsStream("ICON.png"));
			} catch (Exception e) {
				System.out.println("Failed to create SystemTray image. Abouting!");
				return;
			}
			PopupMenu menu = new PopupMenu();
			menuItem_Close = new MenuItem("Close");
			menuItem_Version = new MenuItem("Version");
			menuItem_About = new MenuItem("About");
			
			menu.add(menuItem_Close);
			menu.add(menuItem_Version);
			menu.add(menuItem_About);
			
			//menu.addActionListener(this);
			menuItem_Close.addActionListener(this);
			menuItem_Version.addActionListener(this);
			menuItem_About.addActionListener(this);
			
			TrayIcon icon = new TrayIcon(image, "WebInfo V:" + WebInfo.VERSION, menu);
			
			try {
				tray.add(icon);
			} catch (Exception e) {
				System.out.println("Failed to add SystemTray image. Aborting!");
				return;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("Event: " + event.getSource());
		if (event.getSource().equals(menuItem_About)) {
			JOptionPane.showMessageDialog(null, "WebInfo (V:" + WebInfo.VERSION + ") by Brian McCarthy (WWOL) \r\n");
		} else if (event.getSource().equals(menuItem_Close)) {
			int i = JOptionPane.showConfirmDialog(null, "Really Close?");
			if (i == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "Closing!");
				System.exit(0);
			}
		} else if (event.getSource().equals(menuItem_Version)) {
			JOptionPane.showMessageDialog(null, "WebInfo V:" + WebInfo.VERSION);
		}
	}
}
