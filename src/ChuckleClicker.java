import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements MouseListener {
	JFrame frame = new JFrame("Chuckle Clicker");
	JPanel panel = new JPanel();
	JButton joke = new JButton("Joke");
	JButton punchline = new JButton("Punchline");

	public static void main(String[] args) {
		ChuckleClicker chuckleClicker = new ChuckleClicker();
		chuckleClicker.makeButtons();
	}

	public void makeButtons() {

		joke.addMouseListener(this);
		punchline.addMouseListener(this);

		frame.setVisible(true);
		frame.add(panel);
		panel.add(joke);
		panel.add(punchline);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton pressed = (JButton) e.getSource();
		if (pressed == joke) {
			JOptionPane.showMessageDialog(null, "How did Darth Vader know what Luke got him for Christmas?");
		} else if (pressed == punchline) {
			JOptionPane.showMessageDialog(null, "He felt his presents!");
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
