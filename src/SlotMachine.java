import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SlotMachine implements MouseListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton spin = new JButton("Spin!");
	JLabel one = new JLabel();
	JLabel two = new JLabel();
	JLabel three = new JLabel();
	JLabel youWin = new JLabel();
	JLabel winCounter = new JLabel();
	JLabel rollCounter = new JLabel();
	int wins = 0;
	int rolls = 0;
	int first;
	int second;
	int third;

	public static void main(String[] args) {
		SlotMachine machine = new SlotMachine();
		machine.setup();
	}

	public void setup() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		spin.addMouseListener(this);

		frame.add(panel);
		panel.add(one);
		panel.add(two);
		panel.add(three);
		panel.add(winCounter);
		panel.add(rollCounter);
		panel.add(spin);
		panel.add(youWin);

		one.setPreferredSize(new Dimension(300, 300));
		two.setPreferredSize(new Dimension(300, 300));
		three.setPreferredSize(new Dimension(300, 300));
		winCounter.setText("Wins: " + wins + " |");
		rollCounter.setText("Rolls: " + rolls);

		frame.pack();
	}

	public void reset() {
		frame.remove(panel);
		panel = new JPanel();

		frame.add(panel);
		panel.add(one);
		panel.add(two);
		panel.add(three);
		panel.add(winCounter);
		panel.add(rollCounter);
		panel.add(spin);
		panel.add(youWin);

		winCounter.setText("Wins: " + wins + " |");
		rollCounter.setText("Rolls: " + rolls);

		frame.pack();
	}

	public void roll(int labelNum) {
		int rand = new Random().nextInt(3);

		JLabel label;

		if (rand == 0) {
			label = createLabelImage("shield.jpg");

			// System.out.println("Roll!");
		} else if (rand == 1) {
			label = createLabelImage("helmet.jpg");

			// System.out.println("Roll!");
		} else {
			label = createLabelImage("head.jpeg");

			// System.out.println("Roll!");
		}

		if (labelNum == 1) {
			one = label;
			first = rand;
		} else if (labelNum == 2) {
			two = label;
			second = rand;
		} else if (labelNum == 3) {
			three = label;
			third = rand;
		}
	}

	private JLabel createLabelImage(String fileName) {
		try {
			URL imageURL = getClass().getResource(fileName);
			if (imageURL == null) {
				System.err.println("Could not find image " + fileName);
				return new JLabel();
			} else {
				Icon icon = new ImageIcon(imageURL);
				JLabel imageLabel = new JLabel(icon);
				return imageLabel;
			}
		} catch (Exception e) {
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		roll(1);
		roll(2);
		roll(3);
		reset();

		if (first == second && first == third) {
			wins++;
			youWin.setText("You Win!");
		} else {
			youWin.setText(" ");
		}

		frame.pack();

		rolls++;
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

	public SlotMachine() {
		// TODO Auto-generated constructor stub
	}

}
