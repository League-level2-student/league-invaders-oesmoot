import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	GamePanel gPanel;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	LeagueInvaders() {
		this.frame = new JFrame();
		this.gPanel = new GamePanel();
	}
public static void main(String[] args) {
	LeagueInvaders invader = new LeagueInvaders();
	invader.setup();
}
void setup() {
	frame.add(gPanel);
	frame.setSize(WIDTH, HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.addKeyListener(gPanel);
}
}
 