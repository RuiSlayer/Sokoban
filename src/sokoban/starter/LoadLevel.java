package sokoban.starter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import pt.iul.ista.poo.utils.Point2D;


public class LoadLevel {

	public static Map load(String fileName) {
		Map nivel = new Map();
		try {
			Scanner s = new Scanner(new File(fileName));
			int j = 0;
			
			while(s.hasNextLine()) {
				char[] linha = s.nextLine().toCharArray();
				for(int i = 0;i != linha.length;i++) {
					Point2D pos = new Point2D(i, j);
					nivel.loadAux(pos, linha[i]);
				}
				j++;
			}
			s.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"YOU BEAT THE GAME!!!");
		}
		return nivel;
	}
}
