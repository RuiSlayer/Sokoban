package Movabel_Objs;

import java.util.ArrayList;

import AbstractObjs.AbstractObjs;
import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;
import sokoban.starter.Map;

public class Empilhadora extends Movabel{
	
	private int score = 0;
	private int bateria = 100;
	private boolean marteloEquiped = false;
	
	public Empilhadora(Point2D pos) {
		super("Empilhadora_U",pos,2,false);
	}
	
	public void setName(int lastKeyPressed) {
		fileName="Empilhadora_" + Direction.directionFor(lastKeyPressed).toString().charAt(0);		
	}
	
	public void move(Map nivel, int lastKeyPressed) {
		ArrayList<AbstractObjs> objsNoPonto= nivel.getObjcsOnPoint(getNovapos(lastKeyPressed));
		
		for(AbstractObjs a:objsNoPonto) {
			if(a instanceof Movabel) 
				((Movabel) a).move(nivel, lastKeyPressed);
		}
		setBateria(-1);
		setScore(+1);
		super.move(nivel, lastKeyPressed);
	}
	
	public void movementeRecibe(Map nivel,int lastKeyPressed) {
		if(Direction.isDirection(lastKeyPressed)) {
			setName(lastKeyPressed);
			move(nivel, lastKeyPressed);
			ImageMatrixGUI.getInstance().update();
		}
	}
	
	public void setMartelo(Boolean status) {
		marteloEquiped=status;
	}
	
	public boolean isMartelo() {
		return marteloEquiped;
	}
	
	public void resetStatusVaribles() {
		score = 0;
		bateria = 100;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getBateriaLevel() {
		return bateria;
	}
	
	public void setScore(int value) {
		score += value;
	}
	
	public void setBateria(int value) {
		bateria += value;
	}
	
	public void resetBateria() {
		bateria = 100;
	}

}
