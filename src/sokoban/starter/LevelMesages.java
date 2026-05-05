package sokoban.starter;

import javax.swing.JOptionPane;

public class LevelMesages {
	String playerName;
	
	public static void gameOver() {
		JOptionPane.showMessageDialog(null, "        GAME OVER!!!\n"
				+ "You Fell In The Hole :(");
	}
	
	public static void success() {
		JOptionPane.showMessageDialog(null, "YOU WON !!!");
	}
	
	public static void runOutOffBeta() {
		JOptionPane.showMessageDialog(null, "      GAME OVER!!!\n" 
				+ "YOU RUN OUT OF BATTERY :(");
	}
}
