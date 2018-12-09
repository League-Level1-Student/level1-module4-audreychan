import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TypingTutor implements KeyListener {
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	char currentLetter = generateRandomLetter();

	public static void main(String[] args) {
		TypingTutor typingTutor = new TypingTutor();
		typingTutor.setup();
	}

	void setup() {
		label.setFont(label.getFont().deriveFont(28.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setText(currentLetter + "");

		frame.setVisible(true);
		frame.add(label);
		frame.setTitle("Type or Die");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);

	}

	char generateRandomLetter() {
		Random r = new Random();
		return (char) (r.nextInt(26) + 'a');
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("you typed " + e.getKeyChar());
		if (e.getKeyChar() == currentLetter) {
			System.out.println("correct");
			frame.setBackground(Color.getHSBColor(118, 54, 100));
		} else {
			System.out.println("incorrect");
			frame.setBackground(Color.getHSBColor(2, 68, 91));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		currentLetter = generateRandomLetter();
		label.setText(currentLetter + "");
	}
}
