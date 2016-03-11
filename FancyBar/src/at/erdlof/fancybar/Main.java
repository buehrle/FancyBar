package at.erdlof.fancybar;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class Main extends BlurredJFrame implements MouseListener {
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		this.setUndecorated(true);
		this.setBackground(new Color(0, 0, 0, 1));
		this.setTitle("FancyBar");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1920, 1080);
		this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width, 0);
		this.addMouseListener(this);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		
		super.init();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
