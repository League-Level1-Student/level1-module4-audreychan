import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements MouseListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addB = new JButton("+");
	JButton subB = new JButton("-");
	JButton mulB = new JButton("*");
	JButton divB = new JButton("/");
	JTextField one = new JTextField();
	JTextField two = new JTextField();
	JLabel solutionDisplay = new JLabel();
	String solutionString = new String();
	int solutionInt;

	public void setup() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();

		addB.addMouseListener(this);
		subB.addMouseListener(this);
		mulB.addMouseListener(this);
		divB.addMouseListener(this);

		one.setPreferredSize(new Dimension(150, 30));
		two.setPreferredSize(new Dimension(150, 30));

		frame.add(panel);
		panel.add(one);
		panel.add(two);
		panel.add(addB);
		panel.add(subB);
		panel.add(mulB);
		panel.add(divB);
		panel.add(solutionDisplay);
		frame.setPreferredSize(new Dimension(350, 250));
		frame.pack();

		solutionDisplay.setPreferredSize(new Dimension(50, 50));

	}

	public int add(int first, int second) {
		return first + second;
	}

	public int sub(int first, int second) {
		return first - second;
	}

	public int mul(int first, int second) {
		return first * second;
	}

	public int div(int first, int second) {
		return first / second;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String oneString = one.getText();
		int oneInt = Integer.parseInt(oneString);
		String twoString = two.getText();
		int twoInt = Integer.parseInt(twoString);

		JButton pressed = (JButton) e.getSource();
		if (pressed == addB) {
			solutionInt = add(oneInt, twoInt);
			solutionString = solutionInt + "";
			solutionDisplay.setText(solutionString);
		} else if (pressed == subB) {
			solutionInt = sub(oneInt, twoInt);
			solutionString = solutionInt + "";
			solutionDisplay.setText(solutionString);
		} else if (pressed == mulB) {
			solutionInt = mul(oneInt, twoInt);
			solutionString = solutionInt + "";
			solutionDisplay.setText(solutionString);
		} else if (pressed == divB) {
			solutionInt = div(oneInt, twoInt);
			solutionString = solutionInt + "";
			solutionDisplay.setText(solutionString);
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
