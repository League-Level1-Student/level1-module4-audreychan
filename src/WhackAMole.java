import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements MouseListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	int missed = 0;
	int moles = 0;
	int whacks = 0;
	Date timeAtStart = new Date();

	public static void main(String[] args) {
		WhackAMole whackAMole = new WhackAMole();
		whackAMole.setup();
	}

	public void setup() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(panel);
		frame.setPreferredSize(new Dimension(300, 300));

		drawButtons();
	}

	public void drawButtons() {
		int rand = new Random().nextInt(24);

		for (int i = 0; i < 24; i++) {
			JButton button = new JButton();
			if (i == rand) {
				button.setText("mole!");
			}
			button.addMouseListener(this);
			panel.add(button);
		}
		frame.pack();
	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void endGame(Date timeAtStart, int molesWhacked) {
		Date timeAtEnd = new Date();
		JOptionPane.showMessageDialog(null, "Your whack rate is "
				+ ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked) + " moles per second.");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton pressed = (JButton) e.getSource();
		if (pressed.getText().equals("mole!")) {
			// speak("Congrats!");
			int ran = new Random().nextInt(5);
			if (ran == 0) {
				speak("Congrats");
			} else if (ran == 1) {
				speak("Yep ");
			} else if (ran == 2) {
				speak("Good job ");
			} else if (ran == 3) {
				speak("Hooray ");
			} else if (ran == 4) {
				speak("Thats it!");
			}

			moles++;
			whacks++;
		} else {
			int ran = new Random().nextInt(5);
			if (ran == 0) {
				speak("Sorry");
			} else if (ran == 1) {
				speak("Missed ");
			} else if (ran == 2) {
				speak("Wrong  ");
			} else if (ran == 3) {
				speak("Nope! ");
			} else if (ran == 4) {
				speak("Oops");
			}
			// speak("Nope!");
			missed++;
			whacks++;
		}

		if (whacks == 10) {
			endGame(timeAtStart, moles);
		}

		if (missed == 5) {
			speak("Sorry, you lost");
			endGame(timeAtStart, moles);
		}

		frame.remove(panel);
		panel = new JPanel();
		frame.add(panel);

		drawButtons();
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

	public WhackAMole() {
		// TODO Auto-generated constructor stub
	}

}
