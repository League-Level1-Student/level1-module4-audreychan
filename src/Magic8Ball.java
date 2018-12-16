import java.util.Random;

import javax.swing.JOptionPane;

public class Magic8Ball {
				public static void start() {
					int rand = new Random().nextInt(4);
					System.out.println(rand);
					JOptionPane.showInputDialog("Ask a question to the 8 ball:");
					if(rand == 0) {
						JOptionPane.showMessageDialog(null, "Yes!");
					}
					else if(rand == 1) {
						JOptionPane.showMessageDialog(null, "No.");
					}
					else if(rand == 2) {
						JOptionPane.showMessageDialog(null, "Maybe you should ask Google?");
					}
					else if(rand == 3) {
						JOptionPane.showMessageDialog(null, "How on Earth should I know?");
					}
				}
}