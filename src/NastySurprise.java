import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NastySurprise implements MouseListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton trick = new JButton("Trick");
	JButton treat = new JButton("Treat");
	
	public static void main(String[] args) {
		NastySurprise nastySurprise = new NastySurprise();
		nastySurprise.setup();
	}
	
	void setup() {
		frame.setVisible(true);
		panel.add(trick);
		panel.add(treat);
		frame.add(panel);
		trick.addMouseListener(this);
		treat.addMouseListener(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	private void showPictureFromTheInternet(String imageUrl) {
	     try {
	          URL url = new URL(imageUrl);
	          Icon icon = new ImageIcon(url);
	          JLabel imageLabel = new JLabel(icon);
	          JFrame frame = new JFrame();
	          frame.add(imageLabel);
	          frame.setVisible(true);
	          frame.pack();
	     } catch (MalformedURLException e) {
	          e.printStackTrace();
	     }
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton pressed = (JButton) e.getSource();
		if(pressed == trick) {
			showPictureFromTheInternet("http://cdn.playbuzz.com/cdn/2d19c286-9950-4353-857f-a7422998fe49/34e681ca-6053-4b7e-8933-7d2579ef2821.jpg");
		}
		else if(pressed == treat) {
			showPictureFromTheInternet("https://i.pinimg.com/originals/9a/d7/37/9ad737a202b0501ff494b27847e6300f.jpg");
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
