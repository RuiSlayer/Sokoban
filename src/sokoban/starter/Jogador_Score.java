package sokoban.starter;

import java.util.Comparator;

public class Jogador_Score implements Comparator<Jogador_Score>{
	private String name;
	private int score;
	
	public Jogador_Score(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Jogador_Score [name=" + name + ", score=" + score + "]";
	}

	@Override
	public int compare(Jogador_Score o1, Jogador_Score o2) {
		return o1.getScore()-o2.getScore();
	}
	
	
}
