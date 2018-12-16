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
	JButton add = new JButton("+");
	JButton sub = new JButton("-");
	JButton mul = new JButton("*");
	JButton div = new JButton("/");
	JTextField one = new JTextField();
	JTextField two = new JTextField();
	JLabel three = new JLabel();
	
	String oneString = one.getText();
	int oneInt = Integer.parseInt(oneString);
	String twoString = two.getText();
	int twoInt = Integer.parseInt(twoString);
	
	public void setup() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		
		add.addMouseListener(this);
		sub.addMouseListener(this);
		mul.addMouseListener(this);
		div.addMouseListener(this);
		
		frame.add(panel);
		panel.add(one);
		panel.add(two);
		panel.add(add);
		panel.add(sub);
		panel.add(mul);
		panel.add(div);
		panel.add(three);
		
	}
	public int Add(int first, int second) {
		return first + second;
	}
	public int Subtract(int first, int second) {
		return first - second;
	}
	public int Multiply(int first, int second) {
		return first * second;
	}
	public int Division(int first, int second) {
		return first / second;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton pressed = (JButton) e.getSource();
		if(pressed == add) {
			Add(oneInt, twoInt);
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
