package sokoban.starter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class LeaderBoard {
	
	public static void LerLeaderBoard() {
		ArrayList<Jogador_Score> melhoresJogadores= new ArrayList<Jogador_Score>();
		try {
			Scanner scanner = new Scanner(new File("scores/LeaderBoard" + SokobanGame.getInstance().getNivelNr() + ".txt"));
			
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				String name = line.substring(0, line.indexOf('_'));
				int score = Integer.parseUnsignedInt(line.substring(line.indexOf('_')+1));
				melhoresJogadores.add(new Jogador_Score(name, score));
			}
			scanner.close();
		}
		catch (FileNotFoundException e) {
			System.err.println("ficheiro nao encontrado");
		}
		CriarLeaderBoard(melhoresJogadores);
	}
	
	public static void CriarLeaderBoard(ArrayList<Jogador_Score> melhoresJogadores) {
		try {
			PrintWriter writer = new PrintWriter(new File("scores/LeaderBoard" + SokobanGame.getInstance().getNivelNr() + ".txt"));
			int count=0;
			melhoresJogadores.add(new Jogador_Score(SokobanGame.getInstance().getPlayerName(), SokobanGame.getInstance().getPlayer().getScore()));
			
			Comparator<Jogador_Score> c = (Jogador_Score a, Jogador_Score b) -> a.getScore() - b.getScore();  
			melhoresJogadores.sort(c);
			for(Jogador_Score j : melhoresJogadores ) {
				if(count<5) {
					writer.println(j.getName()+ "_" + j.getScore());
					System.out.println(j.getName()+ "_" + j.getScore());
				}
				else break;
				count++;
			}
			writer.close();
			}
		catch (FileNotFoundException e) {
			System.err.println("problema a escrever o ficheiro");
		}
	}	
}
