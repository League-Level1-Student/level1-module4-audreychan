import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class LatestTweet implements MouseListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField input = new JTextField();
	JButton search = new JButton("Search");
	JLabel tweet = new JLabel();

	public static void main(String[] args) {
		LatestTweet latestTweet = new LatestTweet();
		latestTweet.setup();
	}

	public void setup() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		input.setPreferredSize(new Dimension(150, 30));

		frame.add(panel);
		panel.add(input);
		panel.add(search);
		panel.add(tweet);
		frame.pack();

		search.addMouseListener(this);

	}

	private String getLatestTweet(String searchingFor) {

		Twitter twitter = new TwitterFactory().getInstance();

		AccessToken accessToken = new AccessToken("2453751158-IVD2VGZsvwZiRKxNe3Gs2lMjg30nvSkV1xSuPFf",
				"vBa5PjKfuMTK1LLBG51nCUI9r5d6Ph5cAHrS73spg6Nvu");

		twitter.setOAuthConsumer("YqeZdD2hYxOKv4QOkmp0i2djN", "6XUB1r8KXBvd8Pk9HHW3NgphMxHvHWBLAr5TihnckMU0ttyGST");

		twitter.setOAuthAccessToken(accessToken);

		Query query = new Query(searchingFor);
		try {
			QueryResult result = twitter.search(query);
			return result.getTweets().get(0).getText();
		} catch (Exception e) {
			System.err.print(e.getMessage());
			return "What the heck is that?";
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Tweet tweet!");
		String searchingFor = input.getText();
		tweet.setText(getLatestTweet(searchingFor));
		System.out.println(searchingFor);
		System.out.println(getLatestTweet(searchingFor));
		frame.pack();
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

	public LatestTweet() {
		// TODO Auto-generated constructor stub
	}
	// drag jars into default package, click module 4 > build path > configure build
	// path > add JARs > click jars you want to add > apply and close
}
