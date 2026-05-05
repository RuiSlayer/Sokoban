package Movabel_Objs;


import pt.iul.ista.poo.utils.Point2D;
import sokoban.starter.Map;

public class BigStone extends Movabel {
	public boolean inPosition=false;
	
	public BigStone(Point2D pos) {
		super("BigStone", pos, 2, false);
	}
	
	public void move(Map nivel, int lastKeyPressed) {
		if(!inPosition) {
			super.move(nivel, lastKeyPressed);
		}
	}
	
	public void block() {
		inPosition = true;
	}
	
}
